package com.bank.advancebank.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.advancebank.entity.Adminentity;
public interface Adminrepository extends JpaRepository<Adminentity,Integer>{
	Optional<Adminentity>  findByUsername(String username);
}
