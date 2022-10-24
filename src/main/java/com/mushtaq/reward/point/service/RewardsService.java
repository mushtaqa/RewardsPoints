package com.mushtaq.reward.point.service;

import com.mushtaq.reward.point.model.response.Rewards;

public interface RewardsService {
	public Rewards getRewardsByCustomerId(Long customerId);
	
}
