package com.ogur.airlines.service;

import com.ogur.airlines.model.Account;
import com.ogur.airlines.model.Ticket;
import com.ogur.airlines.repository.AccountRepository;
import com.ogur.airlines.repository.FlightRepository;
import com.ogur.airlines.repository.TicketRepository;
import com.ogur.airlines.util.TicketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService
{
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Ticket addTicket(Integer flightId, Ticket ticket)
    {
        flightRepository.findById(flightId)
                .map(flight -> {
                    ticket.setFlight(flight);
                    ticket.setTicketNumber(TicketUtil.generateTicketNumber("TICKET", flight.getCapacity() ));
                    ticket.setTicketStatus(TicketUtil.TICKET_BUY);
                    return  ticketRepository.save(ticket);
                });

        return  ticketRepository.save(ticket);
    }

    @Override
    public Ticket findTicketByNumber(String ticketNumber)
    {
        return ticketRepository.findTicketByNumber(ticketNumber);
    }

    @Override
    public Ticket cancelTicketByNumber(String ticketNumber)
    {
        Ticket ticket = ticketRepository.findTicketByNumber(ticketNumber);
        ticket.setTicketStatus(TicketUtil.TICKET_CANCEL);
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> listTicketsByFlightIdAnStatus(Integer flightId, String status)
    {
        return ticketRepository.findAll().stream()
                        .filter( ticket -> ticket.getFlight().getId().equals(flightId) && ticket.getTicketStatus().equals(status))
                        .collect(Collectors.toList());
    }

    @Override
    public Ticket buyTicket( Integer flightId, String cardNumber)
    {
        Account account =  accountRepository.findByCardNumber(cardNumber);
        Integer passengerId = account.getPassenger().getId();
        List<Ticket> purchasableTicketList = listTicketsByFlightIdAnStatus(flightId, TicketUtil.TICKET_BUY);

        Random random = new Random( );
        int randomTicket = random.nextInt( purchasableTicketList.size( ) );

        Ticket ticket = purchasableTicketList.get(randomTicket);
        ticket.setTicketStatus(TicketUtil.TICKET_SOLD);
        ticket.setPassenger(account.getPassenger());

        log.info("Sold ticket info = { }", ticket);

        ticketRepository.save(ticket);

        return ticket;
    }

}
