package com.ogur.airlines.service;

import com.ogur.airlines.model.Route;

import java.util.Optional;

public interface RouteService
{
    Route addRoute(Route route);
    Optional<Route> findRouteById(Integer id);
}
