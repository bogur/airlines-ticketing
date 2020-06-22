package com.ogur.airlines.controller;

import com.ogur.airlines.model.Flight;
import com.ogur.airlines.model.Ticket;
import com.ogur.airlines.repository.FlightRepository;
import com.ogur.airlines.repository.TicketRepository;
import com.ogur.airlines.service.FlightService;
import com.ogur.airlines.util.TicketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class FlightController
{
    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    TicketRepository ticketRepository;

    @PostMapping("/flight")
    public ResponseEntity<Flight> addFlight( @RequestParam(name = "companyId") Integer companyId,
                                                @RequestParam(name = "airportId") Integer airportId,
                                                @RequestParam(name = "routeId") Integer routeId,
                                                @RequestBody Flight flight)
    {
        Flight addedFlight = flightService.addFlight(companyId, airportId, routeId, flight);
        log.info("Added flight info = {} ", addedFlight );
        return new ResponseEntity<>( addedFlight, HttpStatus.OK );  // after add flight to database return  full flight information
    }

    @GetMapping("/flight/{flightNumber}")
    public ResponseEntity<Flight> findFlight(@PathVariable(value = "flightNumber") String flightNo )
    {
        Flight flight = flightService.findFlightByNumber(flightNo); // after find flight from database return full flight information
        log.info("Searched flight info = {} ", flight );
        return new ResponseEntity<>(flight, HttpStatus.OK );
    }

    @PostMapping("/flight/{flightNumber}/updateCapacity")
    public ResponseEntity<Flight> updateFlightCapacity(@PathVariable(value = "flightNumber") String flightNo )
    {
        Flight flight = flightService.findFlightByNumber(flightNo); // after find flight from database return full flight information

        int currentCapacity = flight.getCapacity();
        currentCapacity = currentCapacity + currentCapacity * TicketUtil.CAPACITY_PERCENT / 100;

        flight.setCapacity(currentCapacity);

        flightRepository.save( flight );   // update current flight capacity

        List<Ticket> tickets =  ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getFlight().getId() == flight.getId())
                .collect(Collectors.toList());

        tickets.forEach(t-> t.setPrice( t.getPrice() + t.getPrice() * TicketUtil.CAPACITY_PERCENT / 100) ) ;  // update all price of current flight

        ticketRepository.saveAll(tickets);

        log.info("After Update flight capacity flight info = {} ", flight );
        return new ResponseEntity<>(flight, HttpStatus.OK );
    }


}
