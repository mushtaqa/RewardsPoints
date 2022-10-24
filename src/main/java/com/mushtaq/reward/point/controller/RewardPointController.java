package com.mushtaq.reward.point.controller;

import com.mushtaq.reward.point.custom.exception.BusinessException;
import com.mushtaq.reward.point.custom.exception.ControllerException;
import com.mushtaq.reward.point.custom.exception.EmptyInputException;
import com.mushtaq.reward.point.entity.Customer;
import com.mushtaq.reward.point.model.response.Rewards;
import com.mushtaq.reward.point.service.CustomerService;
import com.mushtaq.reward.point.service.RewardsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * this endpoints give all 3 years rewards for customer or endpoint health
 */
@RestController
@Tag(name="reward points application")
public class RewardPointController {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CustomerService customerService;
	@Autowired
	RewardsService rewardsService;

	
	@RequestMapping(value="healthCheck")
	public String healthCheck() {
		return "Reward Point Controller Working Fine...!!!";
	}

	/**
	 * this endpoint gives all 3 years rewards for customer
	 */
	@GetMapping("{customerId}/rewards")
	public ResponseEntity<?> getRewardsByCustomerId( @PathVariable Long customerId) {
		//check for invalid customerId as 0
		if(customerId.longValue()==0l) {
			throw new EmptyInputException("610","Input field is 0 pls provide any value greater than 0");
		}
		try {
			Customer customer = customerService.findByCustomerId(customerId);
			Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
			return new ResponseEntity<Rewards>(customerRewards, HttpStatus.OK);
		} catch(BusinessException be) {
			ControllerException ce = new ControllerException(be.getErrorCode(), be.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			ControllerException ce = new ControllerException("611","something wrong happen in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

}
