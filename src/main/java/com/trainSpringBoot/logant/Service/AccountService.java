package com.trainSpringBoot.logant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainSpringBoot.logant.Entity.Account;
import com.trainSpringBoot.logant.Enum.RecordStatus;
import com.trainSpringBoot.logant.Repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        account.setRecordStatus(RecordStatus.CREATED);
        return accountRepository.save(account);
    }

    @Transactional
    public Account updateAccount(Long id, Account accountDetails) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + id));

        // Update fields
        existingAccount.setAccountHolderName(accountDetails.getAccountHolderName());
        existingAccount.setAccountNumber(accountDetails.getAccountNumber());
        existingAccount.setBalance(accountDetails.getBalance());
        existingAccount.setAccountType(accountDetails.getAccountType());
        existingAccount.setRecordStatus(RecordStatus.UPDATED);

        return accountRepository.save(existingAccount);
    }

    @Transactional
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + id));

        account.setRecordStatus(RecordStatus.DELETED);
        accountRepository.save(account);
    }

    public List<Account> getAccountsNotStatusFour(int status) {
        return accountRepository.findByRecordStatusNot(status);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + id));
    }
}
