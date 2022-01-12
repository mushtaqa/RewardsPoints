package com.mushtaq.reward.point.dto;

import java.io.Serializable;

public class SpendPointDto implements Serializable{

	private static final long serialVersionUID = 5837588800118369176L;
	private String payer;
	private int points;
	
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
}
