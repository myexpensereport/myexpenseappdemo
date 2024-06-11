package com.sp.myexpense.service;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.myexpense.entity.User;
import com.sp.myexpense.repository.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	private static final Integer EXPIRE_MINS = 30;
	private LoadingCache<String, Integer> otpCache;

	public UserServiceImpl(){
		super();
	 otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
			.build(new CacheLoader<String, Integer>() {
				public Integer load(String key) {
					return 0;
				}
			});
	}

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		User userUpdate= findByEmail(user.getEmail());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setRepeatPassword(user.getRepeatPassword());
		return userRepository.save(userUpdate);
	}

	@Override
	public User findByEmail(String email) {

		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	public int generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		try {
			System.out.println(otpCache.get(key)+"KEY:"+key);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return otp;
	}

	public int getOtp(String key) {
		try {
			System.out.println(otpCache.size());
			System.out.println(otpCache.get(key)+"KEY:"+key);
			return otpCache.get(key);
		} catch (Exception e) {
			return 0;
		}
	}

	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}
	
	public void sendOtpMessage(String to, String subject, String message) throws MessagingException {
	
		 MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(message, true);
	        javaMailSender.send(msg);
   }
	
}


