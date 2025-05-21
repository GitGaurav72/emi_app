package com.luckpay.acc.emi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luckpay.acc.emi.entiry.LoanAccount;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, String> {
}