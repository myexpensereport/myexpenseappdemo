package com.sp.myexpense.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TransactionHistoryTest")
public class TransactionHistoryTest {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String schemeName;
	private int investAmount;
	private int expectedAmount;
	private LocalDate updatedDate;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payouthistorytest_id")
    private PayoutHistoryTest payoutHistoryTest;
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "id") private PayoutHistoryTest payoutHistoryTest;
	 */
	
	/**
	 * @return the payoutHistoryTest
	 */
	public PayoutHistoryTest getPayoutHistoryTest() {
		return payoutHistoryTest;
	}
	/**
	 * @param payoutHistoryTest the payoutHistoryTest to set
	 */
	public void setPayoutHistoryTest(PayoutHistoryTest payoutHistoryTest) {
		this.payoutHistoryTest = payoutHistoryTest;
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
	 * @return the updatedDate
	 */
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
	
}
