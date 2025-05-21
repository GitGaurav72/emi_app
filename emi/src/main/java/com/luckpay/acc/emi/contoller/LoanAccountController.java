package com.luckpay.acc.emi.contoller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luckpay.acc.emi.dto.SimplifiedLoanResponse;
import com.luckpay.acc.emi.services.LoanAccountService;



@RestController
@RequestMapping("/api/loan")
public class LoanAccountController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoanAccountController.class);
	
	@Autowired
    private LoanAccountService service;
	

    @GetMapping("/{accountNumber}")
    public ResponseEntity<SimplifiedLoanResponse> getLoanAccount(@PathVariable String accountNumber) {
        SimplifiedLoanResponse response = service.processLoanAccount(accountNumber);
        return ResponseEntity.ok(response);
    }
}