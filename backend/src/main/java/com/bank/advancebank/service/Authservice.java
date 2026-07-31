package com.bank.advancebank.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.advancebank.entity.Accountentity;
import com.bank.advancebank.entity.Adminentity;
import com.bank.advancebank.repository.Accountrepository;
import com.bank.advancebank.repository.Adminrepository;
import com.bank.advancebank.security.JwtUtil;

@Service
public class Authservice {

    private final Adminrepository adminRepository;
    private final Accountrepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public Authservice(Adminrepository adminRepository,
                       Accountrepository accountRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {

        this.adminRepository = adminRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ==========================
    // ADMIN LOGIN
    // ==========================
    public String adminLogin(String username, String password) {

        Optional<Adminentity> admin =
                adminRepository.findByUsername(username);

        if (admin.isEmpty()) {
            throw new RuntimeException("Invalid Username");
        }

        if (!passwordEncoder.matches(password,
                admin.get().getPassword())) {

            throw new RuntimeException("Invalid Password");
        }

        return jwtUtil.generateToken(
                admin.get().getUsername(),
                admin.get().getRole());

    }

    // ==========================
    // CUSTOMER LOGIN
    // ==========================
    public String customerLogin(Long accountNo,
                                String password) {

        Optional<Accountentity> account =
                accountRepository.findByAccountNo(accountNo);

        if (account.isEmpty()) {
            throw new RuntimeException("Account Not Found");
        }

        if (!passwordEncoder.matches(password,
                account.get().getPassword())) {

            throw new RuntimeException("Invalid Password");
        }

        if (!account.get().getStatus().equalsIgnoreCase("ACTIVE")) {

            throw new RuntimeException("Account is not Active");
        }

        return jwtUtil.generateToken(
                String.valueOf(accountNo),
                "ROLE_CUSTOMER");

    }

}