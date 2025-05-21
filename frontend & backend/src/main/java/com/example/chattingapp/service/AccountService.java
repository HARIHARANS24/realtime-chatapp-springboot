package com.example.chattingapp.service;

import com.example.chattingapp.model.Account;
import com.example.chattingapp.model.Status;
import com.example.chattingapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public Account findAccountByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = findAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }

        return new Account(
            account.getUsername(),
            account.getPassword(),
            authorities()
        );
    }

    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    public Account registerAccount(String username, String password) {
        if (accountRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password)); // Encrypt password
        return accountRepository.save(account);
    }

    public List<Account> getConnectedUsers() {
        return accountRepository.findAllByStatus(Status.ONLINE);
    }

    public void saveUser(Account user) {
        var existingUser = accountRepository.findByUsername(user.getUsername()).orElse(null);
        if (existingUser != null) {
            existingUser.setStatus(Status.ONLINE);
            accountRepository.save(existingUser);
        }
    }

    public void disconnect(Account user) {
        var existingUser = accountRepository.findByUsername(user.getUsername()).orElse(null);
        if (existingUser != null) {
            existingUser.setStatus(Status.OFFLINE);
            accountRepository.save(existingUser);
        }
    }

    public List<Account> findConnectedUsers() {
        return accountRepository.findAllByStatus(Status.ONLINE);
    }
}
