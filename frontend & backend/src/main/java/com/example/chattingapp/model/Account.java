package com.example.chattingapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Status status;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public Account(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
}
