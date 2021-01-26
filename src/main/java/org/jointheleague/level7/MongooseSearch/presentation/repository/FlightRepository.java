package org.jointheleague.level7.MongooseSearch.presentation.repository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class FlightRepository {

    private final WebClient webClient;
    private final String baseUrl;


    public FlightRepository() {
        baseUrl = "http://api.aviationstack.com/v1/flights?";
        webClient = WebClient // initializes WebClient in constructor
                .builder() // builds webClient
                .baseUrl(baseUrl) // specifies URL
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // Content header things
                .build(); // builds webClient
    }
    public String getArrivingFlights(String iataAirportCode){
        return "iata code is: " + iataAirportCode;
    }
}
