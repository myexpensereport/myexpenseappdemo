/**
 * 
 */
package com.sp.myexpense.dao;

import java.time.LocalDate;
import java.util.List;

import com.sp.myexpense.entity.PayoutSchemeHistory;

/**
 * 
 */
public class PayoutDto {

	private long id;
	private String schemeName;
	private int investAmount;
	private int expectedAmount;
	private LocalDate startDate;
	private LocalDate endDate;
	private String tenure;
	private LocalDate returnEarnedDate;
	private int interstAmount;
	private int redeem;
	private int bonus;
	private int balanceFund;
	private int totalEarned;
	private String status;
	
	private List<PayoutSchemeHistory> payoutSchemeHistories;
	
	
	
	/**
	 * @return the payoutSchemeHistories
	 */
	public List<PayoutSchemeHistory> getPayoutSchemeHistories() {
		return payoutSchemeHistories;
	}
	/**
	 * @param payoutSchemeHistories the payoutSchemeHistories to set
	 */
	public void setPayoutSchemeHistories(List<PayoutSchemeHistory> payoutSchemeHistories) {
		this.payoutSchemeHistories = payoutSchemeHistories;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the expectedAmount
	 */
	public int getExpectedAmount() {
		return expectedAmount;
	}
	/**
	 * @param expectedAmount the expectedAmount to set
	 */
	public void setExpectedAmount(int expectedAmount) {
		this.expectedAmount = expectedAmount;
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
	/**
	 * @return the tenure
	 */
	public String getTenure() {
		return tenure;
	}
	/**
	 * @param tenure the tenure to set
	 */
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	/**
	 * @return the returnEarnedDate
	 */
	public LocalDate getReturnEarnedDate() {
		return returnEarnedDate;
	}
	/**
	 * @param returnEarnedDate the returnEarnedDate to set
	 */
	public void setReturnEarnedDate(LocalDate returnEarnedDate) {
		this.returnEarnedDate = returnEarnedDate;
	}
	/**
	 * @return the interstAmount
	 */
	public int getInterstAmount() {
		return interstAmount;
	}
	/**
	 * @param interstAmount the interstAmount to set
	 */
	public void setInterstAmount(int interstAmount) {
		this.interstAmount = interstAmount;
	}
	/**
	 * @return the redeem
	 */
	public int getRedeem() {
		return redeem;
	}
	/**
	 * @param redeem the redeem to set
	 */
	public void setRedeem(int redeem) {
		this.redeem = redeem;
	}
	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}
	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	/**
	 * @return the balanceFund
	 */
	public int getBalanceFund() {
		return balanceFund;
	}
	/**
	 * @param balanceFund the balanceFund to set
	 */
	public void setBalanceFund(int balanceFund) {
		this.balanceFund = balanceFund;
	}
	/**
	 * @return the totalEarned
	 */
	public int getTotalEarned() {
		return totalEarned;
	}
	/**
	 * @param totalEarned the totalEarned to set
	 */
	public void setTotalEarned(int totalEarned) {
		this.totalEarned = totalEarned;
	}
	
	
	

}
