package com.java.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.AccountDto;
import com.java.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        System.out.println("controller called");
        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccountDto>> getId(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.get(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll() {
        return new ResponseEntity<>(accountService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawamount(@PathVariable Long id, @RequestBody Map<String, Double> amount) {
    	double amount = request.get("amount");
    	AccountDto accountdto = accountService.withdraw(id, amount);
        return new ResponseEntity<>(accountdto,HttpStatus.OK);
    }
    
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositamount(@PathVariable Long id, @RequestBody Map<String, Double> amount) {
    	double amount = request.get("amount");
    	AccountDto accountdto = accountService.deposit(id, amount);
        return new ResponseEntity<>(accountdto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletebyId(@PathVariable Long id) {
        accountService.deleteId(id);
    }

    @DeleteMapping
    public void deleteAll() {
        accountService.deleteAll();
    }
    
}
