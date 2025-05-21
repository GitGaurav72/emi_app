package com.luckpay.acc.emi.entiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emi_Detail")
public class EmiDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "month")
	private String month; 

	@Column(name = "emi_amount")
	private Double emiAmount; 
	@Column(name = "is_paid")
	private boolean paidStatus; 

	@Column(name = "is_due")
	private boolean dueStatus; 

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public boolean isPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public boolean isDueStatus() {
		return dueStatus;
	}

	public void setDueStatus(boolean dueStatus) {
		this.dueStatus = dueStatus;
	}

	public EmiDetail(String month, Double emiAmount, boolean paidStatus, boolean dueStatus) {
		super();
		this.month = month;
		this.emiAmount = emiAmount;
		this.paidStatus = paidStatus;
		this.dueStatus = dueStatus;
	}

	public EmiDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

}
