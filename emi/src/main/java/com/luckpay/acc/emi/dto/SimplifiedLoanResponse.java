package com.luckpay.acc.emi.dto;

import java.time.LocalDate;

public class SimplifiedLoanResponse {
	
	
    private String loanAccountNumber;
    private LocalDate dueDate;
    private Double emiAmount;
    
	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}
	public SimplifiedLoanResponse(String loanAccountNumber, LocalDate dueDate, Double emiAmount) {
		super();
		this.loanAccountNumber = loanAccountNumber;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
	}
	public SimplifiedLoanResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}