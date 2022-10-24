package com.mushtaq.reward.point.service;

import com.mushtaq.reward.point.entity.Customer;

public interface CustomerService {
	public Customer findByCustomerId(Long customerId);
	
}
