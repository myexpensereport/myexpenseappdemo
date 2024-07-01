/**
 * 
 */
package com.sp.myexpense.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.PayoutSchemeHistory;

/**
 * @author ps149n
 *
 */
@Repository
public interface PayoutSchemeHistoryRepo  extends JpaRepository<PayoutSchemeHistory, Long>{
	
	
	  @Query(nativeQuery = true, value = "select * from  myapp.payout_scheme_history where payoutschemehistory_id = ? ") 
	  List<PayoutSchemeHistory> findPayoutSchemeHistoryById(Long payoutId);
	  
	  @Query(nativeQuery = true, value = "select * from myapp.payout_scheme_history e where  return_earned_date between ?1 and ?2 ")
	   List<PayoutSchemeHistory> findPayoutByMonth(LocalDate startDate, LocalDate endDate);
		
	 

}
