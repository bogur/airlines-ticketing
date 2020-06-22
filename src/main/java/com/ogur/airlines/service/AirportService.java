package com.ogur.airlines.service;

import com.ogur.airlines.model.Airport;

import java.util.Optional;

public interface AirportService
{
    Airport addAirport(Airport airport);
    Optional<Airport> findAirportById( Integer id );
}
