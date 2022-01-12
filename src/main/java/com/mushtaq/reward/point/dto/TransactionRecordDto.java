package com.mushtaq.reward.point.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionRecordDto implements Serializable{

	private static final long serialVersionUID = 6541690815234228584L;

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
