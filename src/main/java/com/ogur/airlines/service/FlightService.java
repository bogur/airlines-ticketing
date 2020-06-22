package com.ogur.airlines.service;

import com.ogur.airlines.model.Flight;

public interface FlightService
{
    Flight addFlight( Integer companyId, Integer airportId, Integer routeId,  Flight flight );
    Flight findFlightByNumber(String flightNumber );  // each flight has a unique flight number.

}
