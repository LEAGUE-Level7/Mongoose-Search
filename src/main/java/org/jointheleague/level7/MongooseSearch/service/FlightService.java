package org.jointheleague.level7.MongooseSearch.service;

import org.jointheleague.level7.MongooseSearch.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String getArrivingFlights(String iataAirportCode){
        return flightRepository.getArrivingFlights(iataAirportCode);
    }
}
