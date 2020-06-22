package com.ogur.airlines.service;

import com.ogur.airlines.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService
{
    List<Passenger> findAll();
    Passenger addPassenger(Passenger passenger);
    Optional<Passenger> findPassengerById(Integer id);
    Passenger findByCreditCardNumber(String cardNumber );
}
