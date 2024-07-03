/**
 * 
 */
package com.sp.myexpense.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.User;
import com.sp.myexpense.repository.ExpenseRepository;

/**
 * 
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	
	
	@Override
	public Expense addExpense(Expense expense) {
		expense.setCreated(LocalDate.now());
		return expenseRepository.save(expense);
	}

	@Override
	public List<Expense> getAllExpense() {
		return expenseRepository.findAllExpense();
		
	}

	@Override
	public List<Expense> getExpenseByLimit(String limit) {

		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.now();
		if(limit.equals("daily")) {
			 endDate = LocalDate.now();
			return expenseRepository.findExpenseByLimit(startDate, endDate);
		}else if(limit.equals("weekly"))
				{
			startDate = LocalDate.now().minusWeeks(1);
			return expenseRepository.findExpenseByLimit(startDate, endDate);
		}
		else if(limit.equals("monthly")){
			
		int	monthDate = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		System.out.println("monthDate:::"+monthDate);
		System.out.println("Year Date:::"+year);
			return expenseRepository.findExpenseByLimit(LocalDate.of(year,monthDate,01), LocalDate.of(year,monthDate,LocalDate.now().lengthOfMonth()));
		}
		else if(limit.equals("annual")){
			int year = LocalDate.now().getYear();
			System.out.println("Year Date:::"+year);
			return expenseRepository.findExpenseByLimit(LocalDate.of(year,01,01), LocalDate.of(year,12,31));
			
		}
		else {
		return expenseRepository.findAll();
		}
		
	}

	


}
