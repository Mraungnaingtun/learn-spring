package com.trainSpringBoot.logant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trainSpringBoot.logant.Entity.Account;
import com.trainSpringBoot.logant.Service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    // Update an account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(id, accountDetails);
        return ResponseEntity.ok(updatedAccount);
    }

    // Delete an account (soft delete by setting recordStatus to DELETED)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    // Get all accounts with a specific recordStatus
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Account>> getAccountsByStatus(@PathVariable int status) {
        List<Account> accounts = accountService.getAccountsNotStatusFour(status);
        return ResponseEntity.ok(accounts);
    }

    // Get an account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }
}
