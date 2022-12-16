package com.semicolon.springBank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String motherMaidenName;
    private String accountNumber;
    private String email;
    private String password;
    private LocalDateTime DOB;
    private int balance;
    @NonNull
    private String phoneNumber;
    private String occupation;
    private String address;
    private LocalDateTime dateRegistered;



}
