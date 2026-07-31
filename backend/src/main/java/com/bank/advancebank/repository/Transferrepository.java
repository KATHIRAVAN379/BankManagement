package com.bank.advancebank.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.advancebank.entity.Transferentity;

import jakarta.transaction.Transactional;
public interface Transferrepository extends JpaRepository<Transferentity,Long>{
	List<Transferentity> findByFromAccount(Long fromAccount);
	List<Transferentity> findByToAccount(Long toAccount);
	
	@Transactional
	void deleteAllByFromAccount(Long accountNo);

	@Transactional
	void deleteAllByToAccount(Long accountNo);
}
