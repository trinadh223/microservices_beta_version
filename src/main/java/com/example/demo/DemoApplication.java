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
	ValidateTokenResponse validateTokenResponse;
	AutoDebitResponse autoDebitResponse;
	CheckBalanceResponse checkBalanceResponse;
	RefundStatusResponse refundStatusResponse;
	TransactionStatusResponse transactionStatusResponse;


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
	public ValidateTokenResponse validatingtoken(){
		ValidateToken token=new ValidateToken(validateOtpResponse.getAccess_token());
		token.validate_token();
		Gson g=new Gson();
		validateTokenResponse= g.fromJson(token.getResponseData(),ValidateTokenResponse.class);
		return validateTokenResponse;
	}



	@RequestMapping("/checkbalance")
	public String checkingbalance(){
		CheckBalance check=new CheckBalance();
		check.check_balance(null);
		Gson g = new Gson();
		checkBalanceResponse=g.fromJson(check.getResponseData(),CheckBalanceResponse.class);
	return check.getResponseData();    }

	@RequestMapping("/revokeaccess")
	public String revokingaccess(){
		RevokeAccess revoke=new RevokeAccess(validateOtpResponse.getAccess_token());
		revoke.revoke_access();
		return revoke.getResponseData();
	}

	@RequestMapping("/autodebit")
	public AutoDebitResponse debiting(@RequestParam(value="amount", defaultValue="0.00") String amount) {
		AutoDebit deb =new AutoDebit(validateTokenResponse.getMobile(),amount);
		deb.auto_debit();
		Gson g=new Gson();
		autoDebitResponse= g.fromJson(deb.getResponseData(),AutoDebitResponse.class);
		return autoDebitResponse;
	}

	@RequestMapping("/transactionstatus")
	public String txnstatus(){
		TransactionStatus stat=new TransactionStatus();
		stat.transaction_status();
		return stat.getResponseData();
	}


	@RequestMapping("/refund")
	public String ref(){
		Refund refu=new Refund(transactionStatusResponse.getORDERID(),transactionStatusResponse.getTXNID(),validateTokenResponse.getMobile());
		refu.refund_init();
		return refu.getResponseData();
	}

	@RequestMapping("/refundstatus")
	public RefundStatusResponse refundstatus(){
		RefundStatus ref = new RefundStatus(transactionStatusResponse.getORDERID(),transactionStatusResponse.getTXNID(),validateTokenResponse.getMobile());
		ref.Refund_status_api();
		Gson g=new Gson();
		refundStatusResponse=g.fromJson(ref.getResponseData(),RefundStatusResponse.class);
		return refundStatusResponse;
	}






}
