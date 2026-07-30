package com.bank.advancebank.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="transaction")
public class Transactionentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private Long accountNo;
	private String transactionType;
	private double amount;
	private double balanceAfterTransaction;
	private String description;
	private LocalDateTime transactionDate;
	public Transactionentity()
	{
		
	}
	public Transactionentity(Long transactionId,Long accountNo,String transactionType,
			          double amount,double balanceAfterTransaction,String description,
                      LocalDateTime transactionDate)
	{
		this.transactionId=transactionId;
		this.accountNo=accountNo;
		this.transactionType=transactionType;
		this.amount=amount;
		this.balanceAfterTransaction=balanceAfterTransaction;
		this.description=description;
		this.transactionDate=transactionDate;
	}
	public void setTransactionId(Long transactionId)
	{
		this.transactionId=transactionId;
	}
	public void setAccountNo(Long accountNo)
	{
		this.accountNo=accountNo;
	}
	public void setTransactionType(String transactionType)
	{
		this.transactionType=transactionType;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public void setBalanceAfterTransaction(double balanceAfterTransaction)
	{
		this.balanceAfterTransaction=balanceAfterTransaction;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public void setTransactionDate(LocalDateTime transactionDate)
	{
		this.transactionDate=transactionDate;
	}
	public Long getTransactionId()
	{
		return transactionId;
	}
	public Long getAccountNo()
	{
		return accountNo;
	}
	public String getTransactionType()
	{
		return transactionType;
	}
	public double getAmount()
	{
		return amount;
	}
	public double getBalanceAfterTransaction()
	{
		return balanceAfterTransaction;
	}
	public String getDescription()
	{
		return description;
	}
	public LocalDateTime getTransactionDate()
	{
		return  transactionDate;
	}
}
