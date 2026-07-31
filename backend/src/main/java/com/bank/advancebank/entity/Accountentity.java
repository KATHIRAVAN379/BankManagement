package com.bank.advancebank.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="account")
public class Accountentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNo;
	private int customerId;
	private String accountType;
	private double balance;
	private String password;
	private boolean firstLogin;
	private String status;
	private LocalDateTime createdAt;
	public Accountentity()
	{
		
	}
	public Accountentity(Long accountNo,int customerId,String accountType,double balance,
			String password,boolean firstLogin,String status,LocalDateTime createdAt)
	{
		this.accountNo=accountNo;
		this.customerId=customerId;
		this.accountType=accountType;
		this.balance=balance;
		this.password=password;
		this.firstLogin=firstLogin;
		this.status=status;
		this.createdAt=createdAt;
	}
	public void setAccountNo(Long accountNo)
	{
		this.accountNo=accountNo;
	}
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	public void setAccountType(String accountType)
	{
		this.accountType=accountType;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setFirstLogin(boolean firstLogin)
	{
		this.firstLogin=firstLogin;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	public void setCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt=createdAt;
	}
	public Long getAccountNo()
	{
		return accountNo;
	}
	public int getCustomerId()
	{
		return customerId;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public double getBalance()
	{
		return balance;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean getFirstLogin()
	{
		return firstLogin;
	}
	public String getStatus()
	{
		return status;
	}
	public LocalDateTime getCreatedAt()
	{
		return createdAt;
	}
}
