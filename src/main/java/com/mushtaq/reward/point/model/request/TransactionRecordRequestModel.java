package com.mushtaq.reward.point.model.request;

import java.util.Date;

public class TransactionRecordRequestModel {
	
	private String payer;
	private int points;
	private Date timestamp;
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
