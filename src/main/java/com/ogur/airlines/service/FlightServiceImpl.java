package com.ogur.airlines.service;

import com.ogur.airlines.model.Flight;
import com.ogur.airlines.repository.AirportRepository;
import com.ogur.airlines.repository.CompanyRepository;
import com.ogur.airlines.repository.FlightRepository;
import com.ogur.airlines.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService
{
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    RouteRepository routeRepository;

    @Override
    public Flight addFlight( Integer companyId, Integer airportId, Integer routeId,  Flight flight )
    {
        flight.setCompany(companyRepository.getOne(companyId));
        flight.setAirport( airportRepository.getOne(airportId) );
        flight.setRoute(routeRepository.getOne(routeId));
        return flightRepository.save( flight );
    }

    @Override
    public Flight findFlightByNumber(String flightNumber)
    {
        return flightRepository.findFlightByNumber(flightNumber);
    }
}
