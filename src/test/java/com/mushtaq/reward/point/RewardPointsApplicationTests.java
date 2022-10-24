package com.mushtaq.reward.point;

import com.mushtaq.reward.point.model.response.Rewards;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardPointsApplicationTests {
	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate;
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	public void setup() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/1001/rewards");
	}

	@Test
	void contextLoads() {
	}

	/**
	 * test is used insert data for test and in the end it will be rollback using annotation rollback
	 */
	@Test
	@Sql(statements = "insert into customer(customer_id, customer_name) values (5001,'Customer1')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10001,5001,'2022-10-12',120)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10002,5001,'2022-09-01',85)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10003,5001,'2022-09-04',160)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10004,5001,'2022-09-01',90)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10005,5001,'2022-08-04',120)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "insert into transaction(transaction_id, customer_id,transaction_date,amount) values (10006,5001,'2022-08-05',165)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Rollback(true)
	public void testGetRewardsByCustomerId() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/5001/rewards");
		Rewards rewards = restTemplate.getForObject(baseUrl, Rewards.class);
		assertNotEquals(null,rewards);
		assertEquals(5001,rewards.getCustomerId());
		assertEquals(110,rewards.getLastMonthRewardPoints());
		assertEquals(305,rewards.getLastSecondMonthRewardPoints());
		assertEquals(355,rewards.getLastThirdMonthRewardPoints());
		assertEquals(770,rewards.getTotalRewards());

	}


}
