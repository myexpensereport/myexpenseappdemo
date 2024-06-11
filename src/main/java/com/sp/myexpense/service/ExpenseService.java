package com.sp.myexpense.service;

import java.util.List;

import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.User;

public interface ExpenseService {
	public Expense addExpense(Expense expense);
	
	public List<Expense> getAllExpense();

	public List<Expense> getExpenseByLimit(String limit);

}
