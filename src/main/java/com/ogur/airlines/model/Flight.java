package com.ogur.airlines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer id ;

    @ManyToOne(cascade = CascadeType.ALL)      // many to one relation between flight and company
    @JoinColumn(name = "flight_company_id")
    @JsonIgnore
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL)      // many to one relation between flight and airport
    @JoinColumn(name = "flight_airport_id")
    @JsonIgnore
    private Airport airport;

    @ManyToOne(cascade = CascadeType.ALL)      // many to one relation between flight and route
    @JoinColumn(name = "flight_route_id")
    @JsonIgnore
    private Route route;

    @Column(name = "flight_number", unique = true)
    private String flightNumber;

    @Column(name = "flight_capacity")
    private int capacity;

    public Flight( )
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

    public Company getCompany()
    {
        return company;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public Airport getAirport()
    {
        return airport;
    }

    public void setAirport(Airport airport)
    {
        this.airport = airport;
    }

    public Route getRoute()
    {
        return route;
    }

    public void setRoute(Route route)
    {
        this.route = route;
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return "Flight{" +
                "id=" + id +
                ", company=" + company +
                ", airport=" + airport +
                ", route=" + route +
                ", flightNumber='" + flightNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
