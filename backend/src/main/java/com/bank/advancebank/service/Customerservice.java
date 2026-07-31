package com.bank.advancebank.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.advancebank.entity.Accountentity;
import com.bank.advancebank.entity.Customerentity;
import com.bank.advancebank.entity.Transactionentity;
import com.bank.advancebank.entity.Transferentity;
import com.bank.advancebank.repository.Accountrepository;
import com.bank.advancebank.repository.Customerrepository;
import com.bank.advancebank.repository.Transactionrepository;
import com.bank.advancebank.repository.Transferrepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.transaction.Transactional;

@Service
public class Customerservice {
	@Autowired
	private Customerrepository customerrepo;
	@Autowired
	private Transactionrepository transactionrepo;
	@Autowired
	private Transferrepository transferrepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Accountrepository accountrepo;
	
	private Accountentity getLoggedInAccount()
	{
	    Authentication authentication =
	            SecurityContextHolder.getContext().getAuthentication();
	    
	    System.out.println("Authentication = " + authentication);
	    System.out.println("Name = " + authentication.getName());
	    System.out.println("Authorities = " + authentication.getAuthorities());

	    Long accountNo =
	            Long.parseLong(authentication.getName());

	    return accountrepo.findByAccountNo(accountNo)
	            .orElseThrow(() ->
	                    new RuntimeException("Account not found"));
	}
	public String changePassword(String oldPassword, String newPassword)
	{
		Accountentity account=getLoggedInAccount();
		if(!passwordEncoder.matches(oldPassword,account.getPassword()))
		{
			throw new RuntimeException("old password is incorrect");
		}
		account.setPassword(passwordEncoder.encode(newPassword));
		account.setFirstLogin(false);
		accountrepo.save(account);
		return "password changed successfully";
	}
	public Customerentity viewProfile()
	{
		Accountentity account=getLoggedInAccount();
		Customerentity customer=customerrepo.findById(account.getCustomerId()).orElseThrow(()
				->new RuntimeException("customer not  found"));
		return customer;
	}
	public Customerentity updateProfile(Customerentity customer)
	{
		Accountentity account=getLoggedInAccount();
		
		Customerentity newcustomer=customerrepo.findById(account.getCustomerId()).orElseThrow(()
				->new RuntimeException("customer not found"));
		if(!newcustomer.getEmail().equals(customer.getEmail()) && 
				customerrepo.findByEmail(customer.getEmail()).isPresent())
		{
			throw new RuntimeException("email already exist");
		}
		if(!newcustomer.getPhone().equals(customer.getPhone()) &&
				customerrepo.findByPhone(customer.getPhone()).isPresent())
		{
			throw new RuntimeException("phone already exist");
		}
		newcustomer.setCustomerName(customer.getCustomerName());
		newcustomer.setGender(customer.getGender());
		newcustomer.setDob(customer.getDob());
		newcustomer.setPhone(customer.getPhone());
		newcustomer.setEmail(customer.getEmail());
		newcustomer.setAddress(customer.getAddress());
		newcustomer.setAadhaarNo(customer.getAadhaarNo());
		newcustomer.setPanNo(customer.getPanNo());
		return customerrepo.save(newcustomer);
			
	}
	public double checkBalance()
	{
		Accountentity account=getLoggedInAccount();
		return account.getBalance();
	}
	@Transactional
	public String deposit(double amount)
	{
		Accountentity account=getLoggedInAccount();
		if(amount<=0)
		{
			throw new RuntimeException("Amount must be in possitive above 0");
		}
		account.setBalance(account.getBalance()+amount);
		accountrepo.save(account);
		Transactionentity trans=new Transactionentity();
		trans.setAccountNo(account.getAccountNo());
		trans.setTransactionType("DEPOSIT");
		trans.setAmount(amount);
		trans.setBalanceAfterTransaction(account.getBalance());
		trans.setDescription("cash deposited");
		trans.setTransactionDate(LocalDateTime.now());
		transactionrepo.save(trans);
		return "deposited successfully";
	}
	@Transactional
	public String withdraw(double amount)
	{
		Accountentity account=getLoggedInAccount();
		if(amount<=0)
		{
			throw new RuntimeException("amount greater then 0");
		}
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insufficient balance");
		}
		account.setBalance(account.getBalance()-amount);
	    accountrepo.save(account);
	    Transactionentity trans=new Transactionentity();
	    trans.setAccountNo(account.getAccountNo());
		trans.setTransactionType("WITHDRAW");
		trans.setAmount(amount);
		trans.setBalanceAfterTransaction(account.getBalance());
		trans.setDescription("cash withdraw");
		trans.setTransactionDate(LocalDateTime.now());
		transactionrepo.save(trans);
		return "withdraw successfully";
	}
	@Transactional
	public String transferMoney(Long toAccount, double amount)
	{
		Accountentity sender=getLoggedInAccount();
		if(amount<=0)
		{
			throw new RuntimeException("Amount must be greater than 0");
		}
		if(sender.getAccountNo().equals(toAccount))
		{
			throw new RuntimeException("both Account cannot be same");
		}
		Accountentity receiver=accountrepo.findByAccountNo(toAccount).orElseThrow(()
				->new RuntimeException("receiver account not found"));
		if(!sender.getStatus().equalsIgnoreCase("ACTIVE"))
		{
			throw new RuntimeException("send id not in active");
		}
		if(!receiver.getStatus().equalsIgnoreCase("ACTIVE"))
		{
			throw new RuntimeException("receiver account is inactive");
		}
		if(sender.getBalance()<amount)
		{
			throw new RuntimeException("insufficient money");
		}
		sender.setBalance(sender.getBalance()-amount);
		receiver.setBalance(receiver.getBalance()+amount);
		accountrepo.save(sender);
		accountrepo.save(receiver);
		Transactionentity debit=new Transactionentity();
		debit.setAccountNo(sender.getAccountNo());
		debit.setTransactionType("TRANSFEROUT");
		debit.setAmount(amount);
		debit.setBalanceAfterTransaction(sender.getBalance());
		debit.setDescription("Transfer to A/c:"+receiver.getAccountNo());
		debit.setTransactionDate(LocalDateTime.now());	
		transactionrepo.save(debit);
		
		Transactionentity credit=new Transactionentity();
		credit.setAccountNo(receiver.getAccountNo());
		credit.setTransactionType("TRANSFERIN");
		credit.setAmount(amount);
		credit.setBalanceAfterTransaction(receiver.getBalance());
		credit.setDescription("received from A/c:"+sender.getAccountNo());
		credit.setTransactionDate(LocalDateTime.now());
		transactionrepo.save(credit);
		
		Transferentity transfer=new Transferentity();
		transfer.setFromaccount(sender.getAccountNo());
		transfer.setToaccount(receiver.getAccountNo());
		transfer.setAmount(amount);
		transfer.setTransferDate(LocalDateTime.now());
		transfer.setStatus("SUCCESS");
		transferrepo.save(transfer);
		
		return "Transfer Successfully";
	}
	public List<Transactionentity> transactionHistory()
	{
		Accountentity account=getLoggedInAccount();
		List<Transactionentity> trans=transactionrepo.findByAccountNo(account.getAccountNo());
		return trans;
	}
	public List<Transferentity> transferHistory()
	{
		Accountentity account=getLoggedInAccount();
		List<Transferentity> his=new ArrayList<>();
		his.addAll(transferrepo.findByFromAccount(account.getAccountNo()));
		his.addAll(transferrepo.findByToAccount(account.getAccountNo()));
		return his;
	}
}