package com.mushtaq.reward.point.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable{

	private static final long serialVersionUID = -4576523049380740997L;
	
	@Id
	@GeneratedValue
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	@Column(name="CUSTOMER_NAME")
	private String customerName;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return customerId == customer.customerId && Objects.equals(customerName, customer.customerName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, customerName);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerId=" + customerId +
				", customerName='" + customerName + '\'' +
				'}';
	}
}
