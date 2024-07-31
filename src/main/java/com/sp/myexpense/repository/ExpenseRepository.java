/**
 * 
 */
package com.sp.myexpense.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.myexpense.entity.Expense;

/**
 * 
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	@Query(nativeQuery = true, value = "select * from myapp.expenses order by created desc")
	List<Expense> findAllExpense();
	
	@Query(nativeQuery = true, 
	        value 
	        = "select * from myapp.expenses e where e.created between ?1 and ?2 order by created desc ")
	List<Expense> findExpenseByLimit(LocalDate startDate, LocalDate endDate);
	@Query(nativeQuery = true, 
	        value 
	        = "select * from myapp.expenses e where e.category = ?1 ")
	List<Expense> findExpenseByCategory(String categoryType);

	

}
