package com.luckpay.acc.emi.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckpay.acc.emi.contoller.LoanAccountController;
import com.luckpay.acc.emi.dto.LoanAccountDTO;

@Component
public class ExternalAPIIntegration {
	
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(LoanAccountController.class);
	public LoanAccountDTO fetchLoanAccount(String accountNumber) {
	    String url = "http://demo9993930.mockable.io/loanaccount/" + accountNumber;

	    LoanAccountDTO response = restTemplate.getForObject(url, LoanAccountDTO.class);

	    try {
	        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
	        logger.info("Fetched LoanAccountDTO:\n{}", json);
	    } catch (JsonProcessingException e) {
	        logger.error("Error serializing LoanAccountDTO", e);
	    }

	    return response;
	}
}