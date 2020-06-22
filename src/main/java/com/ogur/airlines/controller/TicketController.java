package com.ogur.airlines.controller;

import com.ogur.airlines.model.Account;
import com.ogur.airlines.model.Ticket;
import com.ogur.airlines.repository.AccountRepository;
import com.ogur.airlines.repository.FlightRepository;
import com.ogur.airlines.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class TicketController
{
    @Autowired
    TicketService ticketService;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/flight/{flightId}/ticket")
    public ResponseEntity<Ticket> addTicket(@PathVariable(value = "flightId") Integer flightId,
                                              @RequestBody Ticket ticket )
    {
        Ticket addedticket = ticketService.addTicket(flightId, ticket);
        log.info("Added ticket info = {} ", addedticket );
        return new ResponseEntity<>(addedticket, HttpStatus.OK);     // after add account to database return  full account information
    }

    @GetMapping("/ticket/{ticketNumber}")
    public ResponseEntity<Ticket> findTicket(@PathVariable(value = "ticketNumber") String ticketNo )
    {
        Ticket ticket = ticketService.findTicketByNumber(ticketNo);  // after find ticket from database return  ticket information
        log.info("Searched ticket info = {} ", ticket );
        return new ResponseEntity<>(ticket, HttpStatus.OK );
    }

    @PostMapping("/flight/{flightId}/buyTicket")
    public ResponseEntity<Ticket> buyTicket( @PathVariable(value = "flightId") Integer flightId, @RequestBody Account account)
    {
        String cardNumber = account.getCardNumber();
        Ticket ticket = ticketService.buyTicket(flightId, cardNumber);
        return new ResponseEntity<>(ticket, HttpStatus.OK );
    }

    @PostMapping("/ticket/{ticketNumber}")
    public ResponseEntity<Ticket> cancelTicket(@PathVariable(value = "ticketNumber") String ticketNo )
    {
        Ticket ticket = ticketService.cancelTicketByNumber(ticketNo);  // after cancel ticket from database return  ticket information
        log.info("Cancel ticket info = {} ", ticket );

        return new ResponseEntity<>(ticket, HttpStatus.OK );
    }

}
