/**
 * 
 */
package com.sp.myexpense.service;

import java.util.List;

import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.SavingPlan;

/**
 * 
 */
public interface SavingPlanService {
	
	public SavingPlan addSavingPlan(SavingPlan savingplan);
	
	public List<SavingPlan> getAllSavingPlan();

}
