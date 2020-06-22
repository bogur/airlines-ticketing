package com.ogur.airlines.service;

import com.ogur.airlines.repository.AirportRepository;
import com.ogur.airlines.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService
{
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport addAirport(Airport airport)
    {
        return airportRepository.save(airport);
    }

    @Override
    public Optional<Airport> findAirportById(Integer id)
    {
        return airportRepository.findById( id );
    }
}
