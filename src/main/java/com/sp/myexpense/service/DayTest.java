package com.sp.myexpense.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DayTest {

	public static void main(String args[]) {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
//		
		String dateBefore = "2021-05-06";	
		 String dateAfter = "2023-06-07";
		 
		 
		 
//		LocalDate dateBefore =  LocalDate.parse(dateAfter.toString(),dtf);
//		System.out.println("dateBefore:::"+dateBefore);
//		    
//		long daysBetween =  ChronoUnit.DAYS.between(dateBefore, dateAfter);
		
//		    
//		System.out.println(daysBetween);
		
		LocalDate dt1 = LocalDate.parse(dateBefore);
        LocalDate dt2= LocalDate.parse(dateAfter);

        long diffDays = ChronoUnit.DAYS.between(dt1, dt2);
        long monthsBetween= ChronoUnit.MONTHS.between(dt1, dt2);
		long yearsBetween= ChronoUnit.YEARS.between(dt1, dt1);
		System.out.println("@@@ "+Period.between(dt1, dt2).getYears()+" "+Period.between(dt1, dt2).getMonths()+" "+Period.between(dt1, dt2).getDays());

        System.out.println(yearsBetween+":::::::::::"+monthsBetween+"::::diffDays:::"+diffDays);
		
	}
}
