package com.ogur.airlines.repository;

import com.ogur.airlines.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>
{
    @Query(value = "from Flight where flightNumber=:flightNumber")   // get flight by flightNumber
    Flight findFlightByNumber( @Param("flightNumber") String flightNo );

}
