package org.jointheleague.level7.MongooseSearch.presentation.service;

import org.jointheleague.level7.MongooseSearch.presentation.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service // dictates service-layer class (and component)
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String getArrivingFlights(String iataAirportCode){
        return flightRepository.getArrivingFlights(iataAirportCode);
    }

}
