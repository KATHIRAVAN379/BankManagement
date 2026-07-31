package com.bank.advancebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.advancebank.entity.Customerentity;
import com.bank.advancebank.entity.Transactionentity;
import com.bank.advancebank.entity.Transferentity;
import com.bank.advancebank.service.Customerservice;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class Customercontroller {
	@Autowired
	private Customerservice service;
	@PutMapping("/changePassword/{oldPassword}/{newPassword}")
	public String changePassword(@PathVariable String oldPassword,@PathVariable String newPassword)
	{
		return service.changePassword(oldPassword,newPassword);
	}
	@GetMapping("/viewProfile")
	public Customerentity viewProfile()
	{
		return service.viewProfile();
	}
	@PutMapping("/updateProfile")
	public Customerentity updateProfile(@RequestBody Customerentity customer)
	{
		return service.updateProfile(customer);
	}
	@GetMapping("/checkBalance")
	public double checkBalance()
	{
		return service.checkBalance();
	}
	@PostMapping("/deposit/{amount}")
	public String deposit(@PathVariable double amount)
	{
		return service.deposit(amount);
	}
	@PostMapping("/withdraw/{amount}")
	public String withdraw(@PathVariable double amount)
	{
		return service.withdraw(amount);
	}
	@PostMapping("/transferMoney/{toAccount}/{amount}")
	public String transferMoney(@PathVariable Long toAccount,@PathVariable double amount)
	{
		return service.transferMoney(toAccount, amount);
	}
	@GetMapping("/transactionHistory")
	public List<Transactionentity> transactionHistory()
	{
		return service.transactionHistory();
	}
	@GetMapping("/transferHistory")
	public List<Transferentity> transferHistory()
	{
		return service.transferHistory();
	}
}
