package com.luckpay.acc.emi.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckpay.acc.emi.dao.LoanAccountRepository;
import com.luckpay.acc.emi.dto.LoanAccountDTO;
import com.luckpay.acc.emi.dto.SimplifiedLoanResponse;
import com.luckpay.acc.emi.entiry.EmiDetail;
import com.luckpay.acc.emi.entiry.LoanAccount;
import com.luckpay.acc.emi.integration.ExternalAPIIntegration;

@Service
public class LoanAccountService {

	@Autowired
    private ExternalAPIIntegration integration;
	
	@Autowired	
    private LoanAccountRepository repository;
	
    public SimplifiedLoanResponse processLoanAccount(String accountNumber) {
        // Fetch full response from external API
        LoanAccountDTO externalResponse = integration.fetchLoanAccount(accountNumber);

        // Find the first EMI with dueStatus = true
        EmiDetail dueEmi = externalResponse.getEmiDetails().stream()
                .filter(emi -> emi.isDueStatus())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No due EMI found"));

        // Map to simplified response
        SimplifiedLoanResponse simplifiedResponse = new SimplifiedLoanResponse();
        simplifiedResponse.setLoanAccountNumber(externalResponse.getLoanAccountNumber());
        simplifiedResponse.setDueDate(parseMonthToDate(dueEmi.getMonth())); // Implement date parsing
        simplifiedResponse.setEmiAmount(dueEmi.getEmiAmount());

        
        
        
        LoanAccount entity = new LoanAccount(
            simplifiedResponse.getLoanAccountNumber(),
            simplifiedResponse.getDueDate(),
            simplifiedResponse.getEmiAmount()
        );
        repository.save(entity);

        return simplifiedResponse;
    }

    private LocalDate parseMonthToDate(String month) {
        // Example: Convert "April 2024" to "2024-04-01"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        YearMonth yearMonth = YearMonth.parse(month, formatter);
        return yearMonth.atDay(1);
    }
}