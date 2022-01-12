package com.mushtaq.reward.point.model.response;

import java.io.Serializable;

public class SpendPointResponseModel implements Serializable{
	
	private static final long serialVersionUID = 5872081640300607916L;
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
