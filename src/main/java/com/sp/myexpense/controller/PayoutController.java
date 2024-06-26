/**
 * 
 */
package com.sp.myexpense.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.entity.PayoutHistoryTest;
import com.sp.myexpense.entity.TransactionHistoryTest;
import com.sp.myexpense.repository.TrasanctionHistoryRepo;
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
	TrasanctionHistoryRepo historyRepo;
	
	@PostMapping("/addPayout")
	public ResponseEntity<?> addPayout(@RequestBody PayoutDto payoutDto) {
		System.out.println("AddPayout::::::::::::"+payoutDto.getSchemeName());
		PayoutEntity payout = payoutService.addPayout(payoutDto);
		return new ResponseEntity<>(payout, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getPayoutById(@PathVariable("id") Long payoutId) {
		System.out.println("getPayoutById::::::::::::");
		PayoutDto payoutDto = payoutService.getPayoutById(payoutId);
        return ResponseEntity.ok(payoutDto);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatePayout(@PathVariable("id") Long payoutId,@RequestBody PayoutDto payoutDto) {
		System.out.println("Update Payout::::::::::::");
		PayoutEntity payoutDtoUpdate = payoutService.updatePayout(payoutId,payoutDto);
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
		System.out.println("::payoutDtos::"+payoutDtos);
        return ResponseEntity.ok(payoutDtos);
	}
	
	@GetMapping("/getAllPayout/{month}")
	public int getPayoutByMonth(@PathVariable("month") String month) {
		System.out.println("Get getPayoutByMonth :::");
		return payoutService.getPayoutByMonth(month);
	}
	
	/*
	 * @GetMapping("/getSchemeDetails/{schemeId}") public
	 * ResponseEntity<List<PayoutEntity>> getPayoutByMonth(@PathVariable("id") long
	 * schemeId) { System.out.println("Get SchemeDetails :::"); return
	 * ResponseEntity.ok(payoutService.getSchemeDetails(schemeId)); }
	 */
	@PostMapping("/addPayoutTest")
	public ResponseEntity<?> addPayoutTest(@RequestBody PayoutDto payoutDto) {
		System.out.println("AddPayout::::::::::::"+payoutDto.getSchemeName());
		PayoutHistoryTest payout = payoutService.addPayoutTest(payoutDto);
		
			TransactionHistoryTest historyTest = new TransactionHistoryTest();
			historyTest.setSchemeName(payoutDto.getSchemeName());
			historyTest.setExpectedAmount(payoutDto.getExpectedAmount());
			historyTest.setUpdatedDate(LocalDate.now());
			historyTest.setPayoutHistoryTest(payout);
			historyRepo.save(historyTest);
			System.out.println("historyRepo:::Success:::::::::");
			
		return new ResponseEntity<>(payout, HttpStatus.CREATED);
		
	}
	
	/*
	 * @PostMapping("{id}") public ResponseEntity<?>
	 * updatePayoutTest(@PathVariable("id") Long payoutId,@RequestBody PayoutDto
	 * payoutDto) { System.out.println("Update Payout::::::::::::");
	 * 
	 * PayoutHistoryTest payoutDtoUpdate =
	 * payoutService.updatePayoutTest(payoutId,payoutDto);
	 * 
	 * TransactionHistoryTest historyTest = new TransactionHistoryTest();
	 * historyTest.setSchemeName(payoutDto.getSchemeName());
	 * historyTest.setExpectedAmount(payoutDto.getExpectedAmount());
	 * historyTest.setUpdatedDate(LocalDate.now());
	 * historyTest.setPayoutHistoryTest(payoutDtoUpdate);
	 * historyRepo.save(historyTest); return ResponseEntity.ok(payoutDtoUpdate); }
	 */
	
	@GetMapping("/getAllPayoutTest")
	public ResponseEntity<List<PayoutHistoryTest>> getAllPayoutTest() {
		System.out.println("getAllPayoutTest::::::::::::");
		List<PayoutHistoryTest> payoutDtos = payoutService.getAllPayoutTest();
		System.out.println("::payoutDtos::"+payoutDtos);
        return ResponseEntity.ok(payoutDtos);
	}
	
	
	  @PostMapping("{id}")
	  public ResponseEntity<?>getPayoutByIdTest(@PathVariable("id") Long payoutId) {
	  System.out.println("getPayoutById::Test::::::::::"); 
	  PayoutDto payoutDto = payoutService.getPayoutByIdTest(payoutId); 
	  return ResponseEntity.ok(payoutDto); 
	  }
	  
	  @GetMapping("/history/{id}")
	  public ResponseEntity<List<TransactionHistoryTest>> getTransactioHistoryByIdTest(@PathVariable("id") Long payoutId) {
	  System.out.println("getPayoutById::Test::::::::::"); 
	  List<TransactionHistoryTest> transactionHistoryTest = payoutService.getTransactioHistoryByIdTest(payoutId); 
	  return ResponseEntity.ok(transactionHistoryTest);
	  
	  }
	 

}
