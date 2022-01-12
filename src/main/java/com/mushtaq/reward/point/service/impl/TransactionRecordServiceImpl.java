package com.mushtaq.reward.point.service.impl;

import java.util.*;

import com.mushtaq.reward.point.custom.exception.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mushtaq.reward.point.dto.PointBalance;
import com.mushtaq.reward.point.dto.SpendPointDto;
import com.mushtaq.reward.point.dto.TransactionRecordDto;
import com.mushtaq.reward.point.entity.TransactionRecordEntity;
import com.mushtaq.reward.point.model.response.SpendPointResponseModel;
import com.mushtaq.reward.point.model.response.TransactionRecordResponseModel;
import com.mushtaq.reward.point.repository.TransactionRecordRepository;
import com.mushtaq.reward.point.service.TransactionRecordService;

@Service
public class TransactionRecordServiceImpl implements TransactionRecordService{
	
	@Autowired
	TransactionRecordRepository transactionRecordRepository;
	
	@Autowired
	ModelMapper modelMapper;

	public TransactionRecordResponseModel addTransactionRecord(TransactionRecordDto transactionRecordDto) {
		TransactionRecordEntity transactionRecordEntity = modelMapper.map(transactionRecordDto, TransactionRecordEntity.class);
		transactionRecordEntity = transactionRecordRepository.save(transactionRecordEntity);
		TransactionRecordResponseModel transactionRecordResponseModel = modelMapper.map(transactionRecordEntity, TransactionRecordResponseModel.class);
		return transactionRecordResponseModel;
	}

	public List<SpendPointResponseModel> spendpoint(SpendPointDto spendPointDto) {
		List<TransactionRecordEntity> transactionRecordEntityList = transactionRecordRepository.findAllByOrderByTimestampAsc();
		System.out.println(transactionRecordEntityList);
		
		int pointCount = 0;
		int newPointCount = 0;
		int spentCount = 0;
		String payer = "";
		boolean spendflag = true;
		Map<String, Integer> spendPointMap = new LinkedHashMap<String, Integer>();
		
		int points = spendPointDto.getPoints();

		if(points <= 0) {
			throw new BusinessException("601" , "please send value points");
		}
		
		for(TransactionRecordEntity transactionRecordEntity : transactionRecordEntityList) {
			
			System.out.println("transactionRecordEntity: " + transactionRecordEntity);
			
			payer = transactionRecordEntity.getPayer();
			pointCount = transactionRecordEntity.getPoints();
			//System.out.println("payer: " + payer + "~pointCount: " + pointCount);
			if(points == 0) {
				break; 
			}
			else if(points >= pointCount) {
				newPointCount = points - pointCount;
				transactionRecordEntity.setPoints(0);
				points = points - pointCount; // remaining
				spentCount = pointCount; //spending points
				spendflag = true;
			}
			else if(points < pointCount) {
				newPointCount = pointCount - points;
				transactionRecordEntity.setPoints(newPointCount);
				spentCount = points;
				points = 0;
				spendflag = true;
			}
			//System.out.println("spentCount: " + spentCount);
			if(spendflag) {
				if(!spendPointMap.containsKey(payer)) {
					spendPointMap.put(payer, spentCount);
				}else {
					spendPointMap.put(payer, (spendPointMap.get(payer) + spentCount));
				}
				
				spendflag = false;
			}
			
		}
			
		transactionRecordRepository.saveAll(transactionRecordEntityList);
		
		transactionRecordEntityList = transactionRecordRepository.findAll();
		
		List<SpendPointResponseModel> spendPointResponseModelList = new ArrayList<SpendPointResponseModel>();
		for(Map.Entry<String, Integer> entries:spendPointMap.entrySet()) {
			SpendPointResponseModel spendPointResponseModel = new SpendPointResponseModel();
			
			spendPointResponseModel.setPayer(entries.getKey());
			spendPointResponseModel.setPoints(-entries.getValue());
			spendPointResponseModelList.add(spendPointResponseModel);
		}
		return spendPointResponseModelList;
	}

	public Map<String, Long> pointsBalance() {
		List<PointBalance> pointBalanceList = transactionRecordRepository.countPointBalaceByPayer();
		Map<String, Long> pointBalanceMap = new LinkedHashMap<String, Long>();
		for(PointBalance pointBalance : pointBalanceList) {
			pointBalanceMap.put(pointBalance.getPayer(), pointBalance.getPoints());
		}
		return pointBalanceMap;
	}

}
