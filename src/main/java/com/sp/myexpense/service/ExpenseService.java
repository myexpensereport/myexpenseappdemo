package com.sp.myexpense.service;

import java.util.List;
import java.util.Optional;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.SavingPlan;
import com.sp.myexpense.entity.User;

public interface ExpenseService {
	public Expense addExpense(Expense expense);
	
	public List<Expense> getAllExpense();

	public List<Expense> getExpenseByLimit(String limit);
	
	public List<Expense> getAllExpenseByCategory(String categoryType);
	
	SavingPlan updateSavingPlan(Long savingPlanId, SavingPlan plan);
	
	Optional<SavingPlan> getSavingPlanById(Long savingPlanId);
	
	void deleteSavingPlan(Long savingPlanId);
	

}
