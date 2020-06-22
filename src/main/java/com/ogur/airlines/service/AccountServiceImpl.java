package com.ogur.airlines.service;

import com.ogur.airlines.model.Account;
import com.ogur.airlines.model.Passenger;
import com.ogur.airlines.repository.AccountRepository;
import com.ogur.airlines.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public Account findByCardNumber(String cardNumber)
    {
        return accountRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Account addAccount( Integer passengerId, Account account )
    {
        passengerRepository.findById(passengerId)
                .map(passenger -> {
                    account.setPassenger(passenger);
                    return  accountRepository.save(account);
                });

        return  accountRepository.save(account);
    }

    @Override
    public List<Account> findAccountsByPassengerId(Integer passengerId)
    {
        return passengerRepository.findById(passengerId).get().getAccounts( );  //  list all account of passenger by passenger id from account table.
    }

    @Override
    public Optional<Account> findByAccountIdAndPassengerId(Integer accountId, Integer passengerId)
    {
        Passenger passenger = passengerRepository.getOne(passengerId);

        Optional<Account> findedAccount = passenger.getAccounts(  )
                        .stream().filter(account-> account.getId() == accountId )
                        .findAny();

        return findedAccount;
    }


}
