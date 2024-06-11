/**
 * 
 */
package com.sp.myexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.myexpense.entity.SavingPlan;
import com.sp.myexpense.entity.User;

/**
 * 
 */
@Repository
public interface SavingPlanRepo extends JpaRepository<SavingPlan, Long> {

}
