package com.infinite.hib;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="LeaveTable")
public class LeaveTable {
	@Id
	@Column(name="leaveId")

	private int leaveId;
	
	@Column(name="empNo")

	private int empNo;

	@Column(name="leaveStartdate")

	private Date leaveStartdate;
	
	@Column(name="leaveEnddate")

	private Date leaveEnddate;

	@Column(name="noOfDays")

	private int noOfDays;

	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	@Column(name="leaveReason")

	private String leaveReason;
	
	@Column(name="lossOfPay")

	private double lossOfPay;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public Date getLeaveStartdate() {
		return leaveStartdate;
	}
	public void setLeaveStartdate(Date leaveStartdate) {
		this.leaveStartdate = leaveStartdate;
	}
	public Date getLeaveEnddate() {
		return leaveEnddate;
	}
	public void setLeaveEnddate(Date leaveEnddate) {
		this.leaveEnddate = leaveEnddate;
	}
	
	
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public double getLossOfPay() {
		return lossOfPay;
	}
	public void setLossOfPay(double lossOfPay) {
		this.lossOfPay = lossOfPay;
	}
	
}