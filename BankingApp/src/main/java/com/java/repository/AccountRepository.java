package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
