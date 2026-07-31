package com.bank.advancebank.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.advancebank.entity.Transactionentity;

import jakarta.transaction.Transactional;
public interface Transactionrepository extends JpaRepository<Transactionentity,Long>{
	List<Transactionentity> findByAccountNo(Long accountNo);
	@Transactional
    void deleteAllByAccountNo(Long accountNo);
}
