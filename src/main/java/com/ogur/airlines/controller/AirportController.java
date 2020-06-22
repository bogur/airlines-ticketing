package com.ogur.airlines.controller;

import com.ogur.airlines.model.Airport;
import com.ogur.airlines.service.AirportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
public class AirportController
{
    @Autowired
    private AirportService airportService;

    @PostMapping("/airport")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport)
    {
        Airport addedAirport = airportService.addAirport(airport);
        log.info("Added airport info = {} ", addedAirport );
        return new ResponseEntity<>( addedAirport, HttpStatus.OK );  // after add airport to database return  full airport information
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<Optional<Airport>> findAirport( @PathVariable(value = "id") Integer id)
    {
        Optional<Airport> airport = airportService.findAirportById(id); // after find airport from database return full airport information
        log.info("Searched airport info = {} ", airport );
        return new ResponseEntity<>(airport, HttpStatus.OK );
    }
}
