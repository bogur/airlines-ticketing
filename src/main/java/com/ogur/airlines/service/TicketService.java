package com.ogur.airlines.service;

import com.ogur.airlines.model.Ticket;

import java.util.List;

public interface TicketService
{
    List<Ticket> listTicketsByFlightIdAnStatus(Integer flightId, String status );
    Ticket addTicket(Integer flightId, Ticket ticket );
    Ticket findTicketByNumber(String ticketNumber );  // find ticket by ticket number
    Ticket cancelTicketByNumber(String ticketNumber);
    Ticket buyTicket(Integer flightId, String cardNumber);

}
