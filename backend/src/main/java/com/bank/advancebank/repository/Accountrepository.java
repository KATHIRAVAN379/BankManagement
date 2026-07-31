package com.bank.advancebank.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.advancebank.entity.Accountentity;
public interface Accountrepository extends JpaRepository<Accountentity,Long>{
	Optional<Accountentity> findByAccountNo(Long accountNo);
	Optional<Accountentity> findByCustomerId(int customerId);
	Optional<Accountentity> findByCustomerIdAndStatus(int customerId,String status);
}
