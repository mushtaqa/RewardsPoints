package com.mushtaq.reward.point.service.impl;


import com.mushtaq.reward.point.entity.Transaction;

import com.mushtaq.reward.point.model.response.Rewards;
import com.mushtaq.reward.point.repository.TransactionRepository;
import com.mushtaq.reward.point.service.RewardsService;

import com.mushtaq.reward.point.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class RewardsServiceImpl implements RewardsService {
	@Autowired
	TransactionRepository transactionRepository;

	/**
	 * it will return first year , second month, third month and month in 3 years rewards for customer based on amount
	 * spend
	 * @param customerId
	 * @return
	 */
	public Rewards getRewardsByCustomerId(Long customerId) {
		Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(Constants.DAYS_IN_MONTHS);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2*Constants.DAYS_IN_MONTHS);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3*Constants.DAYS_IN_MONTHS);
		List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(customerId
				,lastMonthTimestamp,Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(customerId
				,lastSecondMonthTimestamp,lastMonthTimestamp);

		List<Transaction> lastThirdMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(customerId
				,lastThirdMonthTimestamp,lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getRewardPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardPerMonth(lastThirdMonthTransactions);

		Rewards customerRewards = new Rewards();
		customerRewards.setCustomerId(customerId);
		//total rewards in first month
		customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
		//total rewards in second month
		customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		//total rewards in third month
		customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		//total rewards in three months
		customerRewards.setTotalRewards(lastMonthRewardPoints+lastSecondMonthRewardPoints+lastThirdMonthRewardPoints);

		return customerRewards;
	}

	private Long getRewardPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction->calculateRewards(transaction)).collect(Collectors.summingLong(r->r.longValue()));

	}
	private long calculateRewards(Transaction t) {
		if(t.getTransactionAmount() > Constants.FIRST_REWARDS_LIMIT && t.getTransactionAmount() <= Constants.SECOND_REWARDS_LIMIT) {
			return Math.round(t.getTransactionAmount() - Constants.FIRST_REWARDS_LIMIT);
		} else if (t.getTransactionAmount()  > Constants.SECOND_REWARDS_LIMIT){
			return Math.round((t.getTransactionAmount() - Constants.SECOND_REWARDS_LIMIT)*2
						+(t.getTransactionAmount() - Constants.FIRST_REWARDS_LIMIT));
		} else
			return 0l;

	}

	private Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}
}
