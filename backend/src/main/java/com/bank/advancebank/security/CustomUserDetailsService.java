package com.bank.advancebank.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.advancebank.entity.Accountentity;
import com.bank.advancebank.entity.Adminentity;
import com.bank.advancebank.repository.Accountrepository;
import com.bank.advancebank.repository.Adminrepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Adminrepository adminRepository;
    private final Accountrepository accountRepository;

    public CustomUserDetailsService(Adminrepository adminRepository,
                                    Accountrepository accountRepository) {
        this.adminRepository = adminRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // 1. Check Admin Login
        Optional<Adminentity> admin = adminRepository.findByUsername(username);

        if (admin.isPresent()) {

            return new CustomUserDetails(
                    admin.get().getUsername(),
                    admin.get().getPassword(),
                    admin.get().getRole()
            );
        }

        // 2. Check Customer Login (Account Number)
        try {

            Long accountNo = Long.parseLong(username);

            Optional<Accountentity> account =
                    accountRepository.findByAccountNo(accountNo);

            if (account.isPresent()) {

                return new CustomUserDetails(
                        String.valueOf(account.get().getAccountNo()),
                        account.get().getPassword(),
                        "ROLE_CUSTOMER"
                );
            }

        } catch (NumberFormatException e) {
            // Username is not a valid account number
        }

        throw new UsernameNotFoundException("User not found");
    }

}