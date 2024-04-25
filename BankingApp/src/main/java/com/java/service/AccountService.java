package com.java.service;

import java.util.List;
import java.util.Optional;

import com.java.dto.AccountDto;
// import com.bankingapp.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountdto);

    Optional<AccountDto> get(Long id);

    List<AccountDto> getAll();

    // AccountDTO update(AccountDTO account);

    void deleteId(Long id);

    void deleteAll();

}
