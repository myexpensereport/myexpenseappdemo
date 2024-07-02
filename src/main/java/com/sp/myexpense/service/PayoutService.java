/**
 * 
 */
package com.sp.myexpense.service;

import java.util.List;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.PayoutSchemeHistory;

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
    
   // public int getSchemeHistoryByMonth(String month);
    
    
    List<PayoutSchemeHistory> getPayoutSchemeHistoryById(Long payoutId);

}
