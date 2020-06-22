package com.ogur.airlines.service;

import com.ogur.airlines.model.Passenger;
import com.ogur.airlines.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService
{
    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public List<Passenger> findAll()
    {
        return passengerRepository.findAll( );
    }

    @Override
    public Passenger addPassenger(Passenger passenger)
    {
        return passengerRepository.save(passenger);
    }

    @Override
    public Optional<Passenger> findPassengerById(Integer id)
    {
        return passengerRepository.findById(id);
    }

    @Override
    public Passenger findByCreditCardNumber(String cardNumber) {
        return null;
    }


}
