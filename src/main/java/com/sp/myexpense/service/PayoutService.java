/**
 * 
 */
package com.sp.myexpense.service;

import java.util.List;
import java.util.Optional;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.PayoutHistoryTest;
import com.sp.myexpense.entity.TransactionHistoryTest;

/**
 * 
 */
public interface PayoutService {
	
	public PayoutEntity addPayout(PayoutDto payoutDto );
	
	List<PayoutEntity> getAllPayout();

	PayoutDto getPayoutById(Long payoutId);

	PayoutEntity updatePayout(Long payoutId, PayoutDto payoutDto);

    void deletePayout(Long payoutId);
    
    public int  getPayoutByMonth(String month);
    
   // public List<PayoutEntity>  getSchemeDetails(long schemeId);
    public PayoutHistoryTest addPayoutTest(PayoutDto payoutDto );
    
    PayoutHistoryTest updatePayoutTest(Long payoutId, PayoutDto payoutDto);
    
    List<PayoutHistoryTest> getAllPayoutTest();
    
    PayoutDto getPayoutByIdTest(Long payoutId);
    
    List<TransactionHistoryTest> getTransactioHistoryByIdTest(Long payoutId);


}
