package com.sp.myexpense.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.myexpense.dao.RegisterDto;
import com.sp.myexpense.dao.ValidateOtpDto;
import com.sp.myexpense.entity.Expense;
import com.sp.myexpense.entity.SavingPlan;
import com.sp.myexpense.entity.User;
import com.sp.myexpense.service.ExpenseService;
import com.sp.myexpense.service.SavingPlanService;
import com.sp.myexpense.service.UserService;
import com.sp.myexpense.template.EmailTemplate;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/myexpense")
public class ExpenseController {

	@Autowired
	UserService userService;
	
	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	SavingPlanService savingPlanService;

	@PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null && (existingUser.getEmail().equals(user.getEmail()) && user.getPassword().equals(existingUser.getPassword()))) {
        	System.out.println("Login Success");
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto) {

        // add check for username exists in a DB
//        if(userService.existsByUsername(registerDto.getUsername())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }

        // add check for email exists in DB
		User existingUser = userService.findByEmail(registerDto.getEmail());
		if(existingUser!=null) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

		// create user object
		User user = new User();
		user.setName(registerDto.getName());
		user.setEmail(registerDto.getEmail());
		user.setPassword(registerDto.getPassword());
		user.setRepeatPassword(registerDto.getRepeatPassword());

		userService.saveUser(user);

		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

	}

	@PostMapping("/forgotPassword")
	public String passwordRecovery(@RequestBody User user) throws MessagingException {

		System.out.println("forgotPassword Email ::::"+user.getEmail());
		User emailExists = userService.findByEmail(user.getEmail());
		if (emailExists !=null) {
			int otp = userService.generateOTP(user.getEmail());
			EmailTemplate template = new EmailTemplate("SendOtp.html");
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("user", user.getEmail());
			replacements.put("otpnum", String.valueOf(otp));
			String message = template.getTemplate(replacements);
			// userService.sendOtpMessage("sandhyavijayan92@gmail.com", "OTP-SpringBoot",
			// message);
			userService.sendOtpMessage(user.getEmail(), "OTP-SpringBoot", message);

			return "OTP sent Successfully";
		}
		return "Incorrect email!!!";

	}

	@RequestMapping(value = "/validateOtp", method = RequestMethod.POST)
	public @ResponseBody String validateOtp(@RequestBody ValidateOtpDto validateOtp) {

		System.out.println("Otp is ::::"+validateOtp.getOtp()+"::::::Email:::: " + validateOtp.getEmail());
		int otpnum = validateOtp.getOtp();
		System.out.println("entered otp : " + otpnum);
		String email = validateOtp.getEmail();
		System.out.println("email entered:" + email);
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
		// Validate the Otp
		if (otpnum >= 0) {

			int serverOtp = userService.getOtp(email);
			System.out.println("serverotp :" + serverOtp);
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					System.out.println("success");
					userService.clearOTP(email);

					return ("Entered Otp is valid");
				}

			} else {
				System.out.println("secondlast else");
				return FAIL;
			}
		} else {
			System.out.println("@@LAst else");
			return FAIL;
		}
		return FAIL;
	}
	
	@PutMapping("/updatePassword")
	public User updatePassword(@RequestBody User user) {
		
		return userService.updateUser(user);
	}
	
	@PostMapping("/addExpense")
	public ResponseEntity<?> addExpense(@RequestBody Expense expense) {
		System.out.println("Expense name:::"+expense.getExpenseName()+"::::Category :::"+expense.getCategory()+" Amount is :::"+expense.getAmount());
		expenseService.addExpense(expense);
		return new ResponseEntity<>("Expenses Add Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAllExpense")
	public List<Expense> getExpense() {
		System.out.println("Get Expense :::");
		return expenseService.getAllExpense();
	}
	
	@PostMapping("/addSavingPlan")
	public ResponseEntity<?> addSavingPlan(@RequestBody SavingPlan savingPlan ) {
		System.out.println("SavingPlan:::"+savingPlan.getSchemeName()+"::::Invest Amount :::"+savingPlan.getInvestAmount()+" Amount is :::"+savingPlan.getIntrestAmount());
		System.out.println("StartDate:::"+savingPlan.getStartDate()+"::::End Date :::"+savingPlan.getEndDate());
		
		savingPlanService.addSavingPlan(savingPlan);
		return new ResponseEntity<>("SavingPlan Add Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAllSavingPlan")
	public List<SavingPlan> getAllSavingPlan() {
		System.out.println("Get All SavingPlan :::");
		return savingPlanService.getAllSavingPlan();
	}
	
	@GetMapping("/getAllExpensesReport/{limit}")
	public List<Expense> getAllExpenseReport(@PathVariable("limit") String limit) {
		System.out.println("Get AllExpensesReport :::");
		return expenseService.getExpenseByLimit(limit);
	}


}
