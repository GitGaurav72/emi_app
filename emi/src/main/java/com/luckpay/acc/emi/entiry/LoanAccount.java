package com.luckpay.acc.emi.entiry;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.Cache;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_accounts")
public class LoanAccount {

	@Id
	@Column(name = "loan_account_number", nullable = false, length = 20)
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

	public LoanAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoanAccount(String loanAccountNumber, LocalDate dueDate, Double emiAmount) {
		super();
		this.loanAccountNumber = loanAccountNumber;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
	}

}