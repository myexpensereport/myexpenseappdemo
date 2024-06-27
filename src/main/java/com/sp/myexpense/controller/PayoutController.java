/**
 * 
 */
package com.sp.myexpense.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.PayoutSchemeHistory;
import com.sp.myexpense.repository.PayoutSchemeHistoryRepo;
import com.sp.myexpense.service.PayoutService;

/**
 * 
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/payout")
public class PayoutController {
	
	@Autowired
	PayoutService payoutService;

	@Autowired
	PayoutSchemeHistoryRepo payoutSchemeHistoryRepo;

	@PostMapping("/addPayout")
	public ResponseEntity<?> addPayout(@RequestBody PayoutDto payoutDto) {
		System.out.println("AddPayout::::::::::::" + payoutDto.getSchemeName());
		PayoutEntity payout = payoutService.addPayout(payoutDto);

		PayoutSchemeHistory payoutSchemeHistory = new PayoutSchemeHistory();

		payoutSchemeHistory.setSchemeName(payoutDto.getSchemeName());
		payoutSchemeHistory.setInvestAmount(payoutDto.getInvestAmount());
		payoutSchemeHistory.setExpectedAmount(payoutDto.getExpectedAmount());
		payoutSchemeHistory.setStartDate(payoutDto.getStartDate());
		payoutSchemeHistory.setEndDate(payoutDto.getEndDate());
		payoutSchemeHistory.setTenure(payoutDto.getTenure());
		payoutSchemeHistory.setUpdatedDate(LocalDate.now());
		payoutSchemeHistory.setReturnEarnedDate(payoutDto.getReturnEarnedDate());
		payoutSchemeHistory.setInterstAmount(payoutDto.getInterstAmount());
		payoutSchemeHistory.setRedeem(payoutDto.getRedeem());
		payoutSchemeHistory.setBonus(payoutDto.getBonus());
		payoutSchemeHistory.setBalanceFund(payoutDto.getBalanceFund());
		payoutSchemeHistory.setTotalEarned(payoutDto.getTotalEarned());
		payoutSchemeHistory.setStatus("Active");
		payoutSchemeHistory.setPayoutEntity(payout);

		payoutSchemeHistoryRepo.save(payoutSchemeHistory);
		System.out.println("payoutSchemeHistoryRepo:::Success:::::::::");

		return new ResponseEntity<>(payout, HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<?> getPayoutById(@PathVariable("id") Long payoutId) {
		System.out.println("getPayoutById::::::::::::");
		PayoutDto payoutDto = payoutService.getPayoutById(payoutId);
		return ResponseEntity.ok(payoutDto);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updatePayout(@PathVariable("id") Long payoutId, @RequestBody PayoutDto payoutDto) {
		System.out.println("Update Payout::::::::::::");
		PayoutEntity payoutDtoUpdate = payoutService.updatePayout(payoutId, payoutDto);

		PayoutSchemeHistory payoutSchemeHistory = new PayoutSchemeHistory();
		if (payoutDto.getSchemeName() != null) {
			payoutSchemeHistory.setSchemeName(payoutDtoUpdate.getSchemeName());
		}
		if (payoutDto.getInvestAmount() >= 0) {
			payoutSchemeHistory.setInvestAmount(payoutDtoUpdate.getInvestAmount());
		}
		if (payoutDto.getExpectedAmount() >= 0) {
			payoutSchemeHistory.setExpectedAmount(payoutDtoUpdate.getExpectedAmount());
		}
		if (payoutDto.getStartDate() != null) {
			payoutSchemeHistory.setStartDate(payoutDtoUpdate.getStartDate());
		}
		if (payoutDto.getEndDate() != null) {
			payoutSchemeHistory.setEndDate(payoutDtoUpdate.getEndDate());
			;
		}
		if (payoutDto.getTenure() != null) {
			payoutSchemeHistory.setTenure(payoutDtoUpdate.getTenure());
		}
		if (payoutDto.getInvestAmount() >= 0) {
			payoutSchemeHistory.setInvestAmount(payoutDtoUpdate.getInvestAmount());
		}

		if (payoutDto.getReturnEarnedDate() != null) {
			payoutSchemeHistory.setReturnEarnedDate(payoutDtoUpdate.getReturnEarnedDate());
		}
		if (payoutDto.getInterstAmount() >= 0) {
			payoutSchemeHistory.setInterstAmount(payoutDtoUpdate.getInterstAmount());
		}
		if (payoutDto.getRedeem() >= 0) {
			payoutSchemeHistory.setRedeem(payoutDtoUpdate.getRedeem());
		}
		if (payoutDto.getBonus() >= 0) {
			payoutSchemeHistory.setBonus(payoutDtoUpdate.getBonus());
		}
		if (payoutDto.getBalanceFund() >= 0) {
			payoutSchemeHistory.setBalanceFund(payoutDtoUpdate.getBalanceFund());
		}
		if (payoutDto.getTotalEarned() >= 0) {
			payoutSchemeHistory.setTotalEarned(payoutDtoUpdate.getTotalEarned());
		}
		payoutSchemeHistory.setStatus("Active");
		payoutSchemeHistory.setUpdatedDate(LocalDate.now());
		payoutSchemeHistory.setPayoutEntity(payoutDtoUpdate);
		payoutSchemeHistoryRepo.save(payoutSchemeHistory);
		return ResponseEntity.ok(payoutDtoUpdate);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deletePayout(@PathVariable("id") Long payoutId) {
		System.out.println("DeletePayout::::::::::::");
		payoutService.deletePayout(payoutId);
		return new ResponseEntity<>("Payout Delete Successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllPayout")
	public ResponseEntity<List<PayoutEntity>> getAllPayout() {
		System.out.println("getAllPayout::::::::::::");
		List<PayoutEntity> payoutDtos = payoutService.getAllPayout();
		System.out.println("::payoutDtos::" + payoutDtos);
		return ResponseEntity.ok(payoutDtos);
	}

	@GetMapping("/getAllPayout/{month}")
	public int getPayoutByMonth(@PathVariable("month") String month) {
		System.out.println("Get getPayoutByMonth :::");
		return payoutService.getPayoutByMonth(month);
	}

	@GetMapping("/schemeHistory/{id}")
	public ResponseEntity<List<PayoutSchemeHistory>> getPayoutSchemeHistoryById(@PathVariable("id") Long payoutId) {
		System.out.println("GetPayoutSchemeHistoryById::Test::::::::::");
		List<PayoutSchemeHistory> payoutSchemeHistories = payoutService.getPayoutSchemeHistoryById(payoutId);
		return ResponseEntity.ok(payoutSchemeHistories);

	}
	
	
}
