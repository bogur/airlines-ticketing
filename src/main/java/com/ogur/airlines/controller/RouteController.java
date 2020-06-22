package com.ogur.airlines.controller;

import com.ogur.airlines.model.Route;
import com.ogur.airlines.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
public class RouteController
{
    @Autowired
    private RouteService routeService;

    @PostMapping("/route")
    public ResponseEntity<Route> addRoute(@RequestBody Route route)
    {
        Route addedRoute = routeService.addRoute(route);
        log.info("Added route info = {} ", addedRoute );
        return new ResponseEntity<>( addedRoute, HttpStatus.OK );  // after add route to database return  full route information
    }

    @GetMapping("/route/{id}")
    public ResponseEntity<Optional<Route>> findRoute( @PathVariable(value = "id") Integer id)
    {
        Optional<Route> route = routeService.findRouteById(id); // after find route from database return full route information
        log.info("Searched route info = {} ", route );
        return new ResponseEntity<>(route, HttpStatus.OK );
    }
}
