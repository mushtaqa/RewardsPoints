package com.mushtaq.reward.point.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="TRANSACTION")
public class Transaction implements Serializable{

	private static final long serialVersionUID = -4576523049380740997L;
	
	@Id
	@GeneratedValue
	@Column(name="TRANSACTION_ID")
	private Long transactionId;
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	@Column(name="TRANSACTION_DATE")
	private Timestamp transactionDate;
	@Column(name="AMOUNT")
	private double transactionAmount;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return transactionId == that.transactionId && transactionDate == that.transactionDate && Objects.equals(customerId, that.customerId) && Objects.equals(transactionAmount, that.transactionAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transactionId, customerId, transactionDate, transactionAmount);
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"transactionId=" + transactionId +
				", customerId='" + customerId + '\'' +
				", transactionDate=" + transactionDate +
				", transactionAmount='" + transactionAmount + '\'' +
				'}';
	}
}
