package com.luckpay.acc.emi.dto;

import java.util.List;

import com.luckpay.acc.emi.entiry.EmiDetail;

public class LoanAccountDTO {
    private String loanAccountNumber;
    private List<EmiDetail> emiDetails;
    
    
	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}
	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}
	public List<EmiDetail> getEmiDetails() {
		return emiDetails;
	}
	public void setEmiDetails(List<EmiDetail> emiDetails) {
		this.emiDetails = emiDetails;
	}
	public LoanAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanAccountDTO(String loanAccountNumber, List<EmiDetail> emiDetails) {
		super();
		this.loanAccountNumber = loanAccountNumber;
		this.emiDetails = emiDetails;
	}
	@Override
	public String toString() {
		return "LoanAccountDTO [loanAccountNumber=" + loanAccountNumber + ", emiDetails=" + emiDetails + "]";
	}
    
    
}