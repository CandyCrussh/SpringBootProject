package com.java.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.dto.AccountDto;
import com.java.entity.Account;
import com.java.mapper.AccountMapper;
import com.java.repository.AccountRepository;
import com.java.service.AccountService;

@Service
public class AccountImpl implements AccountService{

    private AccountRepository acc;

    public AccountImpl(AccountRepository acc) {
        this.acc = acc;
    }

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        System.out.println("service layer called");
        Account account = AccountMapper.mapToAccount(accountdto) ;
        Account savedAccount = acc.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);   
    }

    @Override
    public Optional<AccountDto> get(Long id) {
        return acc.findById(id).map(AccountMapper::mapToAccountDTO);
    }

    @Override
    public List<AccountDto> getAll() {
        return acc.findAll()
                .stream()
                .map(AccountMapper::mapToAccountDTO)
                .collect(Collectors.toList());
    }

    // @Override
    // public AccountDTO update(AccountDTO account) {
    //     Account account1 = AccountMapper.mapToAccount(account);
    //     Account savedAccount = acc.save(account1);
    //     return AccountMapper.mapToAccountDTO(savedAccount);
    // }

    @Override
    public void deleteId(Long id) {
        acc.deleteById(id);
    }

    @Override
    public void deleteAll() {
        acc.deleteAll();
    }

    @Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = acc.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient amount");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = acc.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = acc.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
//		if(account.getBalance()>amount) {
//			throw new RuntimeException("Insufficient amount");
//		}
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = acc.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
		return null;
	}

    // @Override
    // public Account create(Account account) {
    //     return acc.save(account);
    //     // throw new UnsupportedOperationException("Unimplemented method 'add'");
    // }

    // @Override
    // public Optional<Account> get(Long id) {
    //     return Optional.of(acc.findById(id).orElseThrow(()-> new RuntimeException("Account not found")));
    //     // throw new UnsupportedOperationException("Unimplemented method 'get'");
    // }

    // @Override
    // public List<Account> getAll() {
    //     return acc.findAll();
    //     // throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    // }

    // @Override
    // public Account update(Account account) {
    //     return acc.save(account);
    //     // throw new UnsupportedOperationException("Unimplemented method 'update'");
    // }

    // @Override
    // public void deleteId(Long id) {
    //     acc.deleteById(id);
    //     // throw new UnsupportedOperationException("Unimplemented method 'delete'");
    // }

    // @Override
    // public void deleteAll() {
    //     acc.deleteAll();
    //     // throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    // }
}
