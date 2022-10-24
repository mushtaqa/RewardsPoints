package com.mushtaq.reward.point.repository;

import com.mushtaq.reward.point.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends  JpaRepository<Transaction, Long>{

	public Transaction findAllByCustomerId(Long customerId);
	public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from , Timestamp to);
}
