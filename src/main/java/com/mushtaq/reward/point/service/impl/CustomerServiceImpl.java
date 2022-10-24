package com.mushtaq.reward.point.service.impl;


import com.mushtaq.reward.point.custom.exception.ControllerException;
import com.mushtaq.reward.point.entity.Customer;
import com.mushtaq.reward.point.repository.CustomerRepository;
import com.mushtaq.reward.point.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public Customer findByCustomerId(Long customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if(customer == null) {
			throw new ControllerException("601", "Invalid / Missing customer Id");
		}
		return customer;
	}
}
