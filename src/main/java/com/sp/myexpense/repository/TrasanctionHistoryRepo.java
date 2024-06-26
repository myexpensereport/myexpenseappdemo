package com.sp.myexpense.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.PayoutHistoryTest;
import com.sp.myexpense.entity.TransactionHistoryTest;

@Repository
public interface TrasanctionHistoryRepo extends JpaRepository<TransactionHistoryTest, Long> {
	
	@Query(nativeQuery = true, value = "select * from  myapp.Transaction_History_Test where payouthistorytest_id = ? ")
	List<TransactionHistoryTest> findTransactionHistoyById(Long payoutId);
	
	//select * from  myapp.Transaction_History_Test where payouthistorytest_id =2;

}
