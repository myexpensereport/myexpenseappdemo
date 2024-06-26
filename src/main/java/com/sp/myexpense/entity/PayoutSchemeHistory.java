/**
 * 
 */
package com.sp.myexpense.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author ps149n
 *
 */
@Entity
@Table(name = "PayoutSchemeHistory")
public class PayoutSchemeHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private LocalDate updatedDate;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payoutschemehistory_id")
    private PayoutEntity payoutEntity;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public int getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(int investAmount) {
		this.investAmount = investAmount;
	}

	public int getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(int expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public LocalDate getReturnEarnedDate() {
		return returnEarnedDate;
	}

	public void setReturnEarnedDate(LocalDate returnEarnedDate) {
		this.returnEarnedDate = returnEarnedDate;
	}

	public int getInterstAmount() {
		return interstAmount;
	}

	public void setInterstAmount(int interstAmount) {
		this.interstAmount = interstAmount;
	}

	public int getRedeem() {
		return redeem;
	}

	public void setRedeem(int redeem) {
		this.redeem = redeem;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getBalanceFund() {
		return balanceFund;
	}

	public void setBalanceFund(int balanceFund) {
		this.balanceFund = balanceFund;
	}

	public int getTotalEarned() {
		return totalEarned;
	}

	public void setTotalEarned(int totalEarned) {
		this.totalEarned = totalEarned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public PayoutEntity getPayoutEntity() {
		return payoutEntity;
	}

	public void setPayoutEntity(PayoutEntity payoutEntity) {
		this.payoutEntity = payoutEntity;
	}


}
