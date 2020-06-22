package com.ogur.airlines.repository;

import com.ogur.airlines.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
    @Query(value = "from Account where cardNumber=:cardNumber")
    Account findByCardNumber(@Param("cardNumber") String cardNumber );

    List<Account> findByPassengerId(Integer passengerId );
    Optional<Account> findByIdAndPassengerId(Integer id, Integer passengerId);
}
