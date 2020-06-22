package com.ogur.airlines.service;

import com.ogur.airlines.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService
{
    Account findByCardNumber(String cardNumber);
    Account addAccount( Integer passengerId, Account account );
    List<Account> findAccountsByPassengerId( Integer passengerId );
    Optional<Account> findByAccountIdAndPassengerId( Integer accountId, Integer passengerId );
}
