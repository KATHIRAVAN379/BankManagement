package com.bank.advancebank.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.advancebank.entity.Customerentity;
public interface Customerrepository extends JpaRepository<Customerentity,Integer>{
	Optional<Customerentity> findByEmail(String email);
	Optional<Customerentity> findByPhone(String phone);
}
