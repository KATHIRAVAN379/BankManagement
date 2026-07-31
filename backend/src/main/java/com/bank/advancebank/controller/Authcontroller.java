package com.bank.advancebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.advancebank.entity.Accountentity;
import com.bank.advancebank.entity.Adminentity;
import com.bank.advancebank.service.Authservice;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class Authcontroller {
	@Autowired
	private Authservice service;
	
	@PostMapping("/adminLogin")
	public String adminLogin(@RequestBody Adminentity admin)
	{
		return service.adminLogin(admin.getUsername(),admin.getPassword());
	}
	@PostMapping("/customerLogin")
	public String customerLogin(@RequestBody Accountentity account)
	{
		return service.customerLogin(account.getAccountNo(),account.getPassword());
	}

}
