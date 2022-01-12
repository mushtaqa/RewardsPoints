package com.mushtaq.reward.point.controller;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;

import com.mushtaq.reward.point.custom.exception.BusinessException;
import com.mushtaq.reward.point.custom.exception.ControllerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mushtaq.reward.point.dto.SpendPointDto;
import com.mushtaq.reward.point.dto.TransactionRecordDto;
import com.mushtaq.reward.point.model.request.SpendPointRequestModel;
import com.mushtaq.reward.point.model.request.TransactionRecordRequestModel;
import com.mushtaq.reward.point.model.response.SpendPointResponseModel;
import com.mushtaq.reward.point.model.response.TransactionRecordResponseModel;
import com.mushtaq.reward.point.service.TransactionRecordService;

@RestController
public class RewardPointController {
	
	@Autowired
	TransactionRecordService transactionRecordService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@RequestMapping(value="healthCheck")
	public String healthCheck() {
		return "Reward Point Controller Working Fine...!!!";
	}
	
	@RequestMapping(value="addTransactionRecord", method=RequestMethod.POST)
	public ResponseEntity<TransactionRecordResponseModel> addTransactionRecord(@RequestBody TransactionRecordRequestModel transactionRecordRequestModel) {
		
		TransactionRecordDto transactionRecordDto = modelMapper.map(transactionRecordRequestModel, TransactionRecordDto.class);
		
		TransactionRecordResponseModel transactionRecordResponseModel = transactionRecordService.addTransactionRecord(transactionRecordDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionRecordResponseModel);
	}
	
	@RequestMapping(value="spendpoints", method=RequestMethod.PUT)
	public ResponseEntity<?> spendpoint(@RequestBody SpendPointRequestModel spendPointRequestModel) {
		try {
			SpendPointDto spendPointDto = modelMapper.map(spendPointRequestModel, SpendPointDto.class);

			List<SpendPointResponseModel> spendPointResponseModelList = transactionRecordService.spendpoint(spendPointDto);

			return ResponseEntity.status(HttpStatus.OK).body(spendPointResponseModelList);
		} catch(BusinessException be) {
			ControllerException ce =  new ControllerException(be.getErrorCode() , be.getErrorMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ce);
		}
	}
	
	@RequestMapping(value="pointsbalance", method=RequestMethod.GET,  produces="application/json")
	public ResponseEntity<String> pointsBalance() {
		
		Map<String, Long> pointBalanceMap = transactionRecordService.pointsBalance();
		ObjectMapper mapper = new ObjectMapper();
		String pointBalance = "";
		try {
			pointBalance = mapper.writeValueAsString(pointBalanceMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(pointBalance);
	}

}
