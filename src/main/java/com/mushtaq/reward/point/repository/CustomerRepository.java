package com.mushtaq.reward.point.repository;


import com.mushtaq.reward.point.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends  JpaRepository<Customer, Long>{


	public Customer findByCustomerId(long customerId);
}
