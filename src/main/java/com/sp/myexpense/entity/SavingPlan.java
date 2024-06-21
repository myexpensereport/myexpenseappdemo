/**
 * 
 */
package com.sp.myexpense.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "savings")
public class SavingPlan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String schemeName;
    private int investAmount;
    private int interestAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    
    
	public int getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(int interestAmount) {
		this.interestAmount = interestAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}
	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
	
	/**
	 * @return the investAmount
	 */
	public int getInvestAmount() {
		return investAmount;
	}
	/**
	 * @param investAmount the investAmount to set
	 */
	public void setInvestAmount(int investAmount) {
		this.investAmount = investAmount;
	}
	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
    

}
