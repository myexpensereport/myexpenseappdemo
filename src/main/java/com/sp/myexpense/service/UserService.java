package com.sp.myexpense.service;

import com.sp.myexpense.entity.User;

import jakarta.mail.MessagingException;

public interface UserService {
	
	public User saveUser(User user);
	public User updateUser(User user);

	public User findByEmail(String email);

	public int generateOTP(String email);

	public void sendOtpMessage(String to, String subject, String message)  throws MessagingException;

	public int getOtp(String email);

	public void clearOTP(String email);
}
