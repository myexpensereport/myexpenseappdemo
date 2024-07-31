/**
 * 
 */
package com.sp.myexpense.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.SavingPlan;
import com.sp.myexpense.entity.User;
import com.sp.myexpense.repository.ExpenseRepository;
import com.sp.myexpense.repository.SavingPlanRepo;

/**
 * 
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	SavingPlanRepo savingPlanRepo;
	
	
	
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
		@Override
		public List<Expense> getAllExpenseByCategory(String categoryType) {

			if(categoryType.equals("MutualFund")) {
				return expenseRepository.findExpenseByCategory(categoryType);
			}else if(categoryType.equals("EMI")){
				return expenseRepository.findExpenseByCategory(categoryType);
			}else if(categoryType.equals("Shopping")){
				return expenseRepository.findExpenseByCategory(categoryType);
			}else if(categoryType.equals("HomeExepnse")){
				return expenseRepository.findExpenseByCategory(categoryType);
			}else if(categoryType.equals("Investment")){
				return expenseRepository.findExpenseByCategory(categoryType);
			}else if(categoryType.equals("Others")){
				return expenseRepository.findExpenseByCategory(categoryType);
			}else {
			return expenseRepository.findAll();
			}
		
	}

		@Override
		public SavingPlan updateSavingPlan(Long savingPlanId, SavingPlan savingPlan) {
			Optional<SavingPlan> savingplanData = savingPlanRepo.findById(savingPlanId);
			if(savingplanData.isPresent()) {
				if(savingPlan.getSchemeName() != null && !(savingplanData.get().getSchemeName().equals(savingPlan.getSchemeName()))) {
					savingplanData.get().setSchemeName(savingPlan.getSchemeName());
				}
				if(savingPlan.getInvestAmount() != 0 && savingplanData.get().getInvestAmount() != savingPlan.getInvestAmount()) {
					savingplanData.get().setInvestAmount(savingPlan.getInvestAmount());
				}
				if(savingPlan.getInterestAmount() !=0 && savingplanData.get().getInterestAmount() != savingPlan.getInterestAmount()) {
					savingplanData.get().setInterestAmount(savingPlan.getInterestAmount());
				}
				if(savingPlan.getStartDate() != null && savingplanData.get().getStartDate() != savingPlan.getStartDate()) {
					System.out.println("StartDate validation "+savingPlan.getStartDate());
					savingplanData.get().setStartDate(savingPlan.getStartDate());
				}
				if(savingPlan.getEndDate() != null && savingplanData.get().getEndDate() != savingPlan.getEndDate()) {
					System.out.println("EndDate validation "+savingPlan.getEndDate());
					savingplanData.get().setEndDate(savingPlan.getEndDate());
				}
				
			}
			return savingPlanRepo.save(savingplanData.get());
		}

		@Override
		public Optional<SavingPlan> getSavingPlanById(Long savingPlanId) {
			Optional<SavingPlan> savingPlanEntity = savingPlanRepo.findById(savingPlanId);
			return savingPlanEntity;
		}

		@Override
		public void deleteSavingPlan(Long savingPlanId) {
			Optional<SavingPlan> savingPlan = savingPlanRepo.findById(savingPlanId);
			 if(savingPlan.isPresent()) {
				 savingPlanRepo.deleteById(savingPlan.get().getId());;
			 }

			
		}

	


}
