package com.sabbagh.bankaccount.service;

import java.util.ArrayList;

import com.sabbagh.bankaccount.exception.AccountNotFoundException;
import com.sabbagh.bankaccount.exception.DuplicateAccountException;
import com.sabbagh.bankaccount.model.BankAccount;

public class BankService {
    private ArrayList<BankAccount> accounts;

    public BankService() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        BankAccount existingAccount = findAccountByNumber(account.getAccountNumber());

        if (existingAccount != null) {
            throw new DuplicateAccountException("Account number already exists");
        }

        accounts.add(account);
    }

    public BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void depositToAccount(String accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        account.deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        account.withdraw(amount);
    }

    public ArrayList<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}
