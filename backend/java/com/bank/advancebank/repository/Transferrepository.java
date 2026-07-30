package com.bank.advancebank.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.advancebank.entity.Transferentity;
public interface Transferrepository extends JpaRepository<Transferentity,Long>{
	List<Transferentity> findByFromAccount(Long fromAccount);
	List<Transferentity> findByToAccount(Long toAccount);
}
