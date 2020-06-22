package com.ogur.airlines.controller;

import com.ogur.airlines.model.Passenger;
import com.ogur.airlines.service.PassengerService;
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
import java.util.Optional;

@Slf4j
@Controller
public class PassengerController
{
    @Autowired
    private PassengerService passengerService;

    @PostMapping("/passenger")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger)
    {
        Passenger addedPassenger = passengerService.addPassenger(passenger);
        log.info("Added passenger info = {} ", addedPassenger );
        return new ResponseEntity<>( addedPassenger, HttpStatus.OK );  // after add passenger to database return  full passenger information
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<Optional<Passenger>> findPassenger( @PathVariable(value = "id") Integer passengerId)
    {
        Optional<Passenger> passenger = passengerService.findPassengerById(passengerId); // after find passenger from database return full passenger information
        log.info("Searched passenger info = {} ", passenger );
        return new ResponseEntity<>(passenger, HttpStatus.OK );
    }

    @GetMapping("/passenger")
    public List<Passenger> findAllPassengers( )
    {
        return passengerService.findAll();
    }
}
