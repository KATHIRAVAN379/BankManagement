package com.bank.advancebank.service;
import java.time.LocalDateTime;


import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.advancebank.entity.Accountentity;
import com.bank.advancebank.entity.Adminentity;
import com.bank.advancebank.entity.Customerentity;
import com.bank.advancebank.entity.Transactionentity;
import com.bank.advancebank.entity.Transferentity;
import com.bank.advancebank.repository.Accountrepository;
import com.bank.advancebank.repository.Adminrepository;
import com.bank.advancebank.repository.Customerrepository;
import com.bank.advancebank.repository.Transactionrepository;
import com.bank.advancebank.repository.Transferrepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Adminservice {
	@Autowired
	private Adminrepository adminrepo;
	@Autowired
	private Customerrepository customerrepo;
	@Autowired
	private Accountrepository accountrepo;
	@Autowired
	private Transactionrepository transactionrepo;
	@Autowired
	private Transferrepository transferrepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Adminentity login(String username,String password)
	{
		Adminentity admin=adminrepo.findByUsername(username).orElseThrow(()
				->new RuntimeException("invalid user"));
		if(!passwordEncoder.matches(password,admin.getPassword()))
		{
			throw new RuntimeException("Invalid password");
		}
		return admin;
	}
	public Customerentity createCustomer(Customerentity customer)
	{
		if(customerrepo.findByEmail(customer.getEmail()).isPresent())
		{
			throw new RuntimeException("EmailAlready Exist");
		}
		if(customerrepo.findByPhone(customer.getPhone()).isPresent())
		{
			throw new RuntimeException("Phone number already exist");
		}
		Customerentity newcustomer=new Customerentity();
		newcustomer.setCustomerName(customer.getCustomerName());
		newcustomer.setGender(customer.getGender());
		newcustomer.setDob(customer.getDob());
		newcustomer.setPhone(customer.getPhone());
		newcustomer.setEmail(customer.getEmail());
		newcustomer.setAddress(customer.getAddress());
		newcustomer.setAadhaarNo(customer.getAadhaarNo());
		newcustomer.setPanNo(customer.getPanNo());
		newcustomer.setCreatedAt(LocalDateTime.now());
		return customerrepo.save(newcustomer);
	}
	public Customerentity updateCustomer(int customerId,Customerentity customer)
	{
		Customerentity existcustomer=customerrepo.findById(customerId).orElseThrow(()->
		new RuntimeException("customer not found"));
		if(!existcustomer.getEmail().equals(customer.getEmail()) && 
		   customerrepo.findByEmail(customer.getEmail()).isPresent())
		{
			throw new RuntimeException("Email Already Exist");
		}
		if(!existcustomer.getPhone().equals(customer.getPhone()) && 
		   customerrepo.findByPhone(customer.getPhone()).isPresent())
				{
					throw new RuntimeException("Phone number Already Exist");
				}
		existcustomer.setCustomerName(customer.getCustomerName());
		existcustomer.setGender(customer.getGender());
		existcustomer.setDob(customer.getDob());
		existcustomer.setPhone(customer.getPhone());
		existcustomer.setEmail(customer.getEmail());
		existcustomer.setAddress(customer.getAddress());
		existcustomer.setAadhaarNo(customer.getAadhaarNo());
		existcustomer.setPanNo(customer.getPanNo());
		return customerrepo.save(existcustomer);
	}
	@Transactional
	public String deleteCustomer(int customerId)
	{
		Customerentity customer=customerrepo.findById(customerId).orElseThrow(()->
		new RuntimeException("customer not found"));
		Accountentity account = accountrepo.findByCustomerId(customerId)
	            .orElse(null);

	    if (account != null) {
	    	Long accountNo=account.getAccountNo();

	        // Delete all transactions of this account
	        transactionrepo.deleteAllByAccountNo(accountNo);
	        //delete transfer
	        transferrepo.deleteAllByFromAccount(accountNo);
	        transferrepo.deleteAllByToAccount(accountNo);
	        // Delete account
	        accountrepo.delete(account);
	    }

	    // Delete customer
	    customerrepo.delete(customer);
		return "customer deleted";
	}
	public Customerentity getCustomerById(int customerId)
	{
		Customerentity customer=customerrepo.findById(customerId).orElseThrow(()
				->new RuntimeException("customer not found"));
		return customer;
	}
	public List<Customerentity> getAllCustomers()
	{
		List<Customerentity> customer=customerrepo.findAll();
		return customer;
	}
	public Accountentity createAccount(int customerId,String accountType,double balance)
	{
		Customerentity customer=customerrepo.findById(customerId).orElseThrow(()->
		                         new RuntimeException("customer not found"));
		if(accountrepo.findByCustomerId(customerId).isPresent())
		{
			throw new RuntimeException("customer already have an account");
		}
		Accountentity account=new Accountentity();
		account.setCustomerId(customer.getCustomerId());
		account.setAccountType(accountType);
		account.setBalance(balance);
		account.setPassword(passwordEncoder.encode("Welcome@123"));
		account.setFirstLogin(true);
		account.setStatus("ACTIVE");
		account.setCreatedAt(LocalDateTime.now());
		return accountrepo.save(account);
		
	}
	public Accountentity getAccountByNumber(Long accountNo)
	{
		Accountentity account=accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		return account;
	}
	public Accountentity activateAccount(Long accountNo)
	{
		Accountentity account=accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		if(account.getStatus().equalsIgnoreCase("ACTIVE"))
		{
			throw new RuntimeException("Account is already active");
		}
		account.setStatus("ACTIVE");
		return accountrepo.save(account);
	}
	public Accountentity freezeAccount(Long accountNo)
	{
		Accountentity account=accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		if(account.getStatus().equalsIgnoreCase("BLOCKED"))
		{
			throw new RuntimeException("Account is already BLOCKED");
		}
		account.setStatus("BLOCKED");
		return accountrepo.save(account);
	}
	public Accountentity closeAccount(Long accountNo)
	{
		Accountentity account=accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		if(account.getStatus().equalsIgnoreCase("INACTIVE"))
		{
			throw new RuntimeException("Account is already INACTIVE");
		}
		account.setStatus("INACTIVE");
		return accountrepo.save(account);
	}
	public String  resetPassword(Long accountNo)
	{
		Accountentity account=accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		account.setPassword(passwordEncoder.encode("Welcome@123"));
		account.setFirstLogin(true);
		accountrepo.save(account);
		return "password reset successfully";
		
	}
	public double checkBalance(Long accountNo)
	{
		Accountentity account=accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		return account.getBalance();
	}
	public List<Accountentity> getAllAccounts()
	{
		List<Accountentity> account=accountrepo.findAll();
		return account;
	}
	public List<Transactionentity> getTransactionsByAccount(Long accountNo)
	{
		accountrepo.findByAccountNo(accountNo).orElseThrow(()
				->new RuntimeException("account not found"));
		List<Transactionentity> trans=transactionrepo.findByAccountNo(accountNo);
		return trans;
	}
	public List<Transactionentity> getAllTransactions()
	{
		List<Transactionentity> trans=transactionrepo.findAll();
		return trans;
	}
	public List<Transferentity> getTransfersByAccount(Long accountNo)
	{
		accountrepo.findByAccountNo(accountNo).orElseThrow(()->new RuntimeException("account not found"));
		List<Transferentity> trans=new ArrayList<>();
		trans.addAll(transferrepo.findByFromAccount(accountNo));
		trans.addAll(transferrepo.findByToAccount(accountNo));
		return trans;
	}
	public List<Transferentity> getAllTransfers()
	{
		List<Transferentity> trans=transferrepo.findAll();
		return trans;
	}
	public long totalCustomers()
	{
		return customerrepo.count();
	}
	public long totalAccounts()
	{
		return accountrepo.count();
	}
	public long totalTransactions()
	{
		return transactionrepo.count();
	}
	public double totalBankBalance()
	{
		List<Accountentity> account=accountrepo.findAll();
		double total=0;
		for(Accountentity acc:account)
		{
			total+=acc.getBalance();
		}
		return total;
	}
}
