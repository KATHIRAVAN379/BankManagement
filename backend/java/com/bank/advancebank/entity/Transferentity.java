package com.bank.advancebank.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="transfer")
public class Transferentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transferId;
	private Long fromAccount;
	private Long toAccount;
	private double amount;
	private LocalDateTime transferDate;
	private String status;
	public Transferentity()
	{
		
	}
	public Transferentity(Long transferId,Long fromAccount,Long toAccount,
			double amount,LocalDateTime transferDate,String status)
	{
		this.transferId=transferId;
		this.fromAccount=fromAccount;
		this.toAccount=toAccount;
		this.amount=amount;
		this.transferDate=transferDate;
		this.status=status;
	}
	public void setTransferId(Long transferId)
	{
		this.transferId=transferId;
	}
	public void setFromaccount(Long fromAccount)
	{
		this.fromAccount=fromAccount;
	}
	public void setToaccount(Long toAccount)
	{
		this.toAccount=toAccount;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public void setTransferDate(LocalDateTime transferDate)
	{
		this.transferDate=transferDate;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	public Long getTransferId()
	{
		return transferId;
	}
	public Long getFromAccount()
	{
		return fromAccount;
	}
	public Long getToAccount()
	{
		return toAccount;
	}
	public double getAmount()
	{
		return amount;
	}
	public LocalDateTime getTransferDate()
	{
		return transferDate;
	}
	public String getStatus()
	{
		return status;
	}
}
