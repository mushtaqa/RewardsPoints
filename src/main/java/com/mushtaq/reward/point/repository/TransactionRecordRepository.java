package com.mushtaq.reward.point.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mushtaq.reward.point.dto.PointBalance;
import com.mushtaq.reward.point.entity.TransactionRecordEntity;

@Repository
public interface TransactionRecordRepository extends  JpaRepository<TransactionRecordEntity, Long>{

	public List<TransactionRecordEntity> findAllByOrderByTimestampAsc();
	
	@Query(
			value = "with q1 as (\n" +
					"SELECT rownum, TRANSACTION_RECORD.* FROM TRANSACTION_RECORD),\n" +
					"q2 as (SELECT payer,  SUM(points) total_points ,min(rownum) minid FROM q1 GROUP BY payer)\n" +
					"SELECT payer, total_points as points FROM q2\n" +
					"Order by minid",
			nativeQuery = true)
	List<PointBalance> countPointBalaceByPayer();
}
