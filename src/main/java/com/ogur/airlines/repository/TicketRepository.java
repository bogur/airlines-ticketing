package com.ogur.airlines.repository;

import com.ogur.airlines.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
    @Query(value = "from Ticket where ticketNumber=:ticketNumber")   // get ticket by ticketNumber
    Ticket findTicketByNumber(@Param("ticketNumber") String ticketNo);

}
