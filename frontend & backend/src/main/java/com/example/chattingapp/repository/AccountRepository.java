package com.example.chattingapp.repository;

import com.example.chattingapp.model.Account;
import com.example.chattingapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    List<Account> findAllByStatus(Status status);
}
