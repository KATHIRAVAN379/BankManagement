package com.bank.advancebank.entity;
import java.time.LocalDate;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="customer")
public class Customerentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String gender;
	private LocalDate dob;
	private String phone;
	private String email;
	private String address;
	private String aadhaarNo;
	private String panNo;
	private LocalDateTime createdAt;
	public Customerentity()
	{
		
	}
	public Customerentity(int customerId,String customerName,String gender,LocalDate dob,
                   String phone,String email,String address,String aadhaarNo,String panNo,
                   LocalDateTime createdAt)
	{
		this.customerId=customerId;
		this.customerName=customerName;
		this.gender=gender;
		this.dob=dob;
		this.phone=phone;
		this.email=email;
		this.address=address;
		this.aadhaarNo=aadhaarNo;
		this.panNo=panNo;
		this.createdAt=createdAt;
	}
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName=customerName;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public void setDob(LocalDate dob)
	{
		this.dob=dob;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setAadhaarNo(String aadhaarNo)
	{
		this.aadhaarNo=aadhaarNo;
	}
	public void setPanNo(String panNo)
	{
		this.panNo=panNo;
	}
	public void setCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt=createdAt;
	}
	public int getCustomerId()
	{
		return customerId;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public String getGender()
	{
		return gender;
	}
	public LocalDate getDob()
	{
		return dob;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public String getAddress()
	{
		return address;
	}
	public String getAadhaarNo()
	{
		return aadhaarNo;
	}
	public String getPanNo()
	{
		return panNo;
	}
	public LocalDateTime getCreatedAt()
	{
		return createdAt;
	}
}
