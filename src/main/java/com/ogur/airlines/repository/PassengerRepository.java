package com.ogur.airlines.repository;

import com.ogur.airlines.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository  extends JpaRepository<Passenger, Integer>
{
    
}
