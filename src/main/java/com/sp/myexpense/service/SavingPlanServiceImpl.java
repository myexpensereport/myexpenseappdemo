/**
 * 
 */
package com.sp.myexpense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.SavingPlan;
import com.sp.myexpense.repository.SavingPlanRepo;

/**
 * 
 */
@Service
public class SavingPlanServiceImpl implements SavingPlanService{

	@Autowired
	SavingPlanRepo planRepo;
	
	@Override
	public SavingPlan addSavingPlan(SavingPlan savingplan) {
		savingplan.setStatus("Active");
		return planRepo.save(savingplan);
	}

	@Override
	public List<SavingPlan> getAllSavingPlan() {
		 return planRepo.findAll();
	}

}
