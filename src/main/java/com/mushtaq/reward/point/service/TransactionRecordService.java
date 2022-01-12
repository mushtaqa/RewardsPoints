package com.mushtaq.reward.point.service;

import java.util.List;
import java.util.Map;

import com.mushtaq.reward.point.dto.SpendPointDto;
import com.mushtaq.reward.point.dto.TransactionRecordDto;
import com.mushtaq.reward.point.model.response.SpendPointResponseModel;
import com.mushtaq.reward.point.model.response.TransactionRecordResponseModel;

public interface TransactionRecordService {

	public TransactionRecordResponseModel addTransactionRecord(TransactionRecordDto transactionRecordDto);

	public List<SpendPointResponseModel> spendpoint(SpendPointDto spendPointDto);

	public Map<String, Long> pointsBalance();
	
}
