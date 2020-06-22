package com.ogur.airlines.controller;

import com.ogur.airlines.model.Account;
import com.ogur.airlines.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Controller
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @PostMapping("/passenger/{passengerId}/account")
    public ResponseEntity<Account> addAccount( @PathVariable(value = "passengerId") Integer passengerId,
                                               @RequestBody Account account )
    {
        Account addedAccount = accountService.addAccount(passengerId, account);

        log.info("Added account info = {} ", addedAccount );
        return new ResponseEntity<>(addedAccount, HttpStatus.OK);     // after add account to database return  full account information
    }

    @GetMapping("/passenger/{passengerId}/account")
    public  ResponseEntity<List<Account>> findAccountsByPassenger(@PathVariable(value = "passengerId") Integer passengerId)
    {
        List<Account>  accounts =  accountService.findAccountsByPassengerId(passengerId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

}
