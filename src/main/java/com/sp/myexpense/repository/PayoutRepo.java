/**
 * 
 */
package com.sp.myexpense.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.PayoutEntity;


/**
 * 
 */
@Repository
public interface PayoutRepo extends JpaRepository<PayoutEntity, Long> {
	
	@Query(nativeQuery = true, value = "select * from myapp.payout order by return_earned_date desc")
	List<PayoutEntity> findAllPayout();
	
	
	@Query(nativeQuery = true, value = "select * from myapp.payout e where  return_earned_date between ?1 and ?2 order by return_earned_date desc")
	List<PayoutEntity> findPayoutByMonth(LocalDate startDate, LocalDate endDate);
	
	/*
	 * @Query(nativeQuery = true, value =
	 * "select * from myapp.payout e where  start_date between ?1 and ?2 ")
	 * List<PayoutEntity> findPayoutByMonth(String schemeName, LocalDate endDate);
	 */

}
