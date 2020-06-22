package com.ogur.airlines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer id ;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "ticket_status")
    private String ticketStatus;

    @Column(name = "ticket_price")
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_flight_id")
    @JsonIgnore
    private Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)      // many to one relation between passenger
    @JoinColumn(name = "ticket_passenger_id")
    @JsonIgnore
    private Passenger passenger;

    public Ticket()
    {

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTicketNumber()
    {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber)
    {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketStatus()
    {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }

    public Passenger getPassenger()
    {
        return passenger;
    }

    public void setPassenger(Passenger passenger)
    {
        this.passenger = passenger;
    }

    @Override
    public String toString()
    {
        return "Ticket{" +
                "id=" + id +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", price=" + price +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }
}
