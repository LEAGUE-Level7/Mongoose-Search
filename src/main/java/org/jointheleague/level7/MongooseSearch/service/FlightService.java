package org.jointheleague.level7.MongooseSearch.service;

import org.jointheleague.level7.MongooseSearch.repository.dto.AviationStackResponse;
import org.jointheleague.level7.MongooseSearch.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public AviationStackResponse getArrivingFlights(String iataAirportCode){
        return flightRepository.getArrivingFlights(iataAirportCode);
    }

    public AviationStackResponse getDepartingFlights(String iataAirportCode){
        return flightRepository.getDepartingFlights(iataAirportCode);
    }
}
