package com.ogur.airlines.service;

import com.ogur.airlines.repository.RouteRepository;
import com.ogur.airlines.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService
{
    @Autowired
    private RouteRepository routeRepository;


    @Override
    public Route addRoute(Route route)
    {
        return routeRepository.save(route);
    }

    @Override
    public Optional<Route> findRouteById(Integer id)
    {
        return routeRepository.findById( id );
    }
}
