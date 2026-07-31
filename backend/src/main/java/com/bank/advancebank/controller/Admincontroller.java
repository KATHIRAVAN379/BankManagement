package com.bank.advancebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.advancebank.entity.Accountentity;
import com.bank.advancebank.entity.Customerentity;
import com.bank.advancebank.entity.Transactionentity;
import com.bank.advancebank.entity.Transferentity;
import com.bank.advancebank.service.Adminservice;
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/admin")
@RestController
public class Admincontroller {
	@Autowired
	private Adminservice service;
	@PostMapping("/customer")
	public Customerentity createCustomer(@RequestBody Customerentity customer)
	{
		return service.createCustomer(customer);
	}
	@PutMapping("/customer/{customerId}")
	public Customerentity updateCustomer(@PathVariable int customerId,@RequestBody Customerentity customer)
	{
		return service.updateCustomer(customerId, customer);
	}
	@DeleteMapping("/customer/{customerId}")
	public String deleteCustomer(@PathVariable int customerId)
	{
		return service.deleteCustomer(customerId);
	}
	@GetMapping("/customer/{customerId}")
	public Customerentity getCustomerById(@PathVariable int customerId)
	{
		return service.getCustomerById(customerId);
	}
	@GetMapping("/customer")
	public List<Customerentity> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	@PostMapping("/account/{customerId}/{accountType}/{balance}")
	public Accountentity createAccount(@PathVariable int customerId,
			@PathVariable String accountType,@PathVariable double balance)
	{
		return service.createAccount(customerId, accountType, balance);
	}
	@GetMapping("/account/{accountNo}")
	public Accountentity getAccountByNumber(@PathVariable Long accountNo)
	{
		return service.getAccountByNumber(accountNo);
	}
	@PutMapping("/account/activate/{accountNo}")
	public Accountentity activateAccount(@PathVariable Long accountNo)
	{
		return service.activateAccount(accountNo);
	}
	@PutMapping("/account/freeze/{accountNo}")
	public Accountentity freezeAccount(@PathVariable Long accountNo)
	{
		return service.freezeAccount(accountNo);
	}
	@PutMapping("/account/close/{accountNo}")
	public Accountentity closeAccount(@PathVariable Long accountNo)
	{
		return service.closeAccount(accountNo);
	}
	@PutMapping("/account/reset/{accountNo}")
	public String resetPassword(@PathVariable Long accountNo)
	{
		return service.resetPassword(accountNo);
	}
	@GetMapping("/account/balance/{accountNo}")
	public double checkBalance(@PathVariable Long accountNo)
	{
		return service.checkBalance(accountNo);
	}
	@GetMapping("/accounts")
	public List<Accountentity> getAllAccounts()
	{
		return service.getAllAccounts();
	}
	@GetMapping("/transaction/{accountNo}")
	public List<Transactionentity> getTransactionsByAccount(@PathVariable Long accountNo)
	{
		return service.getTransactionsByAccount(accountNo);
	}
	@GetMapping("/transaction")
	public List<Transactionentity> getAllTransactions()
	{
		return service.getAllTransactions();
	}
	@GetMapping("/transfer")
	public List<Transferentity> getAllTransfers()
	{
		return service.getAllTransfers();
	}
	@GetMapping("/transfer/{accountNo}")
	public List<Transferentity> getTransfersByAccount(@PathVariable Long accountNo)
	{
		return service.getTransfersByAccount(accountNo);
	}
	@GetMapping("/totalCustomers")
	public long totalCustomers()
	{
		return service.totalCustomers();
	}
	@GetMapping("/totalAccounts")
	public long totalAccounts()
	{
		return service.totalAccounts();
	}
	@GetMapping("/totalTransactions")
	public long totalTransactions()
	{
		return service.totalTransactions();
	}
	@GetMapping("/totalBankBalance")
	public double totalBankBalance()
	{
		return service.totalBankBalance();
	}
}
