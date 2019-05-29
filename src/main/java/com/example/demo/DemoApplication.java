package com.example.demo;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@SpringBootApplication
@RestController
public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello() {
		return "hello world!";
	}

	private static final String template = "%s";
	private final AtomicLong counter = new AtomicLong();
	Account account;
	SendOtpResponse otpresponse;
	ValidateOtpResponse validateOtpResponse;


	@RequestMapping("/sendotp")
	public SendOtpResponse sendingotp(@RequestParam(value="number", defaultValue="World") String number ) {
		SendOtp so = new SendOtp("", "+91" + number);
		so.Send_OTP();
		account=new Account(counter.incrementAndGet(), String.format(template, number));


		Gson g=new Gson();
		otpresponse= g.fromJson(so.getResponseData(),SendOtpResponse.class);
		return otpresponse;
	}

	@RequestMapping("/validateotp")
	public ValidateOtpResponse validatingotp(@RequestParam(value="otp", defaultValue="111111") String otp) {
		ValidateOtp votp =new ValidateOtp(otp,otpresponse.getState());
		votp.validate_OTP();
		Gson g=new Gson();
		validateOtpResponse= g.fromJson(votp.getResponseData(),ValidateOtpResponse.class);
		return validateOtpResponse;
	}

	@RequestMapping("/validatetoken")
	public String validatingtoken(){
		ValidateToken token=new ValidateToken(validateOtpResponse.getAccess_token());
		token.validate_token();
		return token.getResponseData();
	}

	@RequestMapping("/checkbalance")
	public String checkingbalance(){
		CheckBalance check=new CheckBalance(validateOtpResponse.getAccess_token());
		check.check_balance();
		return check.getResponseData();
	}


}
