/**
 * 
 */
package com.sp.myexpense.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.myexpense.dao.PayoutDto;
import com.sp.myexpense.entity.PayoutEntity;
import com.sp.myexpense.repository.PayoutRepo;

/**
 * 
 */
@Service
public class PayoutServiceImpl implements PayoutService {
	
	@Autowired
	PayoutRepo payoutRepo ;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public PayoutEntity addPayout(PayoutDto payoutDto) {
		PayoutEntity payoutEntity = new PayoutEntity();
		payoutEntity = mapper.map(payoutDto, PayoutEntity.class);
	    payoutEntity = payoutRepo.save(payoutEntity);
		
		return payoutEntity;
	}

	@Override
	public List<PayoutEntity> getAllPayout() {
		List<PayoutEntity> payoutEntity = payoutRepo.findAll();
		for(PayoutEntity payout : payoutEntity){
			String noOfDays = getNumberOfDays(payout.getStartDate(),payout.getEndDate());
			int balanceFund = getBalanceFund(payout.getInvestAmount(),payout.getRedeem());
			payout.setTenure(noOfDays);
			payout.setBalanceFund(balanceFund);
		}
		
		System.out.println(payoutEntity);
		System.out.println(payoutEntity.stream().map(p->mapper.map(payoutEntity, PayoutDto.class)).collect(Collectors.toList()));

		return payoutEntity;
	}

	@Override
	public PayoutDto getPayoutById(Long payoutId) {
		Optional<PayoutEntity> payoutEntity = payoutRepo.findById(payoutId);
		return mapper.map(payoutEntity.get(), PayoutDto.class);
	}

	@Override
	public PayoutEntity updatePayout(Long payoutId, PayoutDto payoutDto) {
		Optional<PayoutEntity> payoutEntity = payoutRepo.findById(payoutId);
		if(payoutEntity.isPresent()) {
			if(payoutDto.getSchemeName() != null && !(payoutEntity.get().getSchemeName().equals(payoutDto.getSchemeName()))) {
				payoutEntity.get().setSchemeName(payoutDto.getSchemeName());
			}
			if(payoutDto.getInvestAmount() != 0 && payoutEntity.get().getInvestAmount() != payoutDto.getInvestAmount()) {
				payoutEntity.get().setInvestAmount(payoutDto.getInvestAmount());
			}
			if(payoutDto.getInterstAmount() !=0 && payoutEntity.get().getInterstAmount() != payoutDto.getInterstAmount()) {
				payoutEntity.get().setExpectedAmount(payoutDto.getExpectedAmount());
			}
			if(payoutDto.getTenure() != null && !(payoutEntity.get().getTenure().equals(payoutDto.getTenure()))) {
				payoutEntity.get().setTenure(payoutDto.getTenure());
			}
			if(payoutDto.getExpectedAmount() != 0 && payoutEntity.get().getExpectedAmount() != payoutDto.getExpectedAmount ()) {
				payoutEntity.get().setInterstAmount(payoutDto.getExpectedAmount());
			}
			if(payoutDto.getStartDate() != null && payoutEntity.get().getStartDate() != payoutDto.getStartDate()) {
				System.out.println("StartDate validation "+payoutDto.getStartDate());
				payoutEntity.get().setStartDate(payoutDto.getStartDate());
			}
			if(payoutDto.getEndDate() != null && payoutEntity.get().getEndDate() != payoutDto.getEndDate()) {
				System.out.println("EndDate validation "+payoutDto.getEndDate());
				payoutEntity.get().setEndDate(payoutDto.getEndDate());
			}
			if(payoutDto.getReturnEarnedDate() != null && payoutEntity.get().getReturnEarnedDate() != payoutDto.getReturnEarnedDate()) {
				System.out.println("Earned Date validation "+payoutDto.getReturnEarnedDate());
				payoutEntity.get().setReturnEarnedDate(payoutDto.getReturnEarnedDate());
			}
			
			if(payoutDto.getBalanceFund() !=0 && payoutEntity.get().getBalanceFund() != payoutDto.getBalanceFund()) {
				payoutEntity.get().setRedeem(payoutDto.getRedeem());
			}
			if(payoutDto.getRedeem() != 0 && payoutEntity.get().getRedeem() != payoutDto.getRedeem()) {
				payoutEntity.get().setBalanceFund(payoutDto.getBalanceFund());
			}
			if(payoutDto.getStatus() != null && payoutEntity.get().getStatus().equalsIgnoreCase(payoutDto.getStatus())) {
				payoutEntity.get().setStatus(payoutDto.getStatus());
			}
		}
		return payoutRepo.save(payoutEntity.get());
	}

	@Override
	public void deletePayout(Long payoutId) {
		Optional<PayoutEntity> payoutEntity = payoutRepo.findById(payoutId);
		 if(payoutEntity.isPresent()) {
			 payoutRepo.deleteById(payoutEntity.get().getId());;
		 }
	}

	private String getNumberOfDays(LocalDate startDate, LocalDate endDate) {
		
		Period period = Period.between(startDate, endDate);
		String totalDays = period.getYears()+" Years "+period.getMonths()+" Months "+period.getDays()+" Days";
		return totalDays;
	}
	
	private int getBalanceFund(int inverstAmount , int  reedem) {
		
		return inverstAmount-reedem;
	}

	@Override
	public int getPayoutByMonth(String month) {
		
		List<PayoutEntity> list ;
		if(month.equals("Jan")) {
			System.out.println("jan");
			list = payoutRepo.findPayoutByMonth(LocalDate.of(2024, 01, 01), LocalDate.of(2024, 01, 31));
			return getPayoutRes(list);
		}
		if(month.equals("Feb")) {
			System.out.println("Feb");
			list=payoutRepo.findPayoutByMonth(LocalDate.of(2024, 02, 01), LocalDate.of(2024, 02, 28));
		    return getPayoutRes(list);
		}
		if(month.equals("Mar")) {
			System.out.println("Mar");
			list = payoutRepo.findPayoutByMonth(LocalDate.of(2024, 03, 01), LocalDate.of(2024, 03, 31));
			 return getPayoutRes(list);
		}
		if(month.equals("Apr")) {
			System.out.println("Apr");
			list= payoutRepo.findPayoutByMonth(LocalDate.of(2024, 04, 01), LocalDate.of(2024, 04, 30));
			return getPayoutRes(list);
		}
		if(month.equals("May")) {
			System.out.println("May");
			list= payoutRepo.findPayoutByMonth(LocalDate.of(2024, 05, 01), LocalDate.of(2024, 05, 31));
			return getPayoutRes(list);
		}
		if(month.equals("June")) {
			System.out.println("June");
			list=payoutRepo.findPayoutByMonth(LocalDate.of(2024, 06, 01), LocalDate.of(2024, 06, 30));
			return getPayoutRes(list);
		}
		if(month.equals("July")) {
			System.out.println("July");
			list= payoutRepo.findPayoutByMonth(LocalDate.of(2024, 07, 01), LocalDate.of(2024, 07, 31));
			return getPayoutRes(list);
		}
		if(month.equals("Aug")) {
			System.out.println("Aug");
			list=payoutRepo.findPayoutByMonth(LocalDate.of(2024, 8, 01), LocalDate.of(2024, 8, 31));
			return getPayoutRes(list);
		}
		if(month.equals("Sept")) {
			System.out.println("Sept");
			list=payoutRepo.findPayoutByMonth(LocalDate.of(2024, 9, 01), LocalDate.of(2024, 9, 30));
			return getPayoutRes(list);
		}if(month.equals("Oct")) {
			System.out.println("Oct");
			list= payoutRepo.findPayoutByMonth(LocalDate.of(2024, 10, 01), LocalDate.of(2024, 10, 30));
			return getPayoutRes(list);
		}
		if(month.equals("Nov")) {
			System.out.println("Nov");
			list= payoutRepo.findPayoutByMonth(LocalDate.of(2024, 11, 01), LocalDate.of(2024, 11, 30));
			return getPayoutRes(list);
		}
		if(month.equals("Dec")) {
			System.out.println("Dec");
			list= payoutRepo.findPayoutByMonth(LocalDate.of(2024, 12, 01), LocalDate.of(2024, 12, 31));
			return getPayoutRes(list);
		}
		return 0;
	}

	private int getPayoutRes(List<PayoutEntity> list) {
		int payoutRes =0;
		for(PayoutEntity entity :list) {
			int res =entity.getInterstAmount()+entity.getBonus();
			payoutRes = payoutRes+ res;
		}
		System.out.println("payoutRes:::"+payoutRes);
		return payoutRes;
	}
	
}
