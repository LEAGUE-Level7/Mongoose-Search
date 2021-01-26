package org.jointheleague.level7.MongooseSearch.repository;

import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;


@Repository
public class FlightRepository {
    private final WebClient webClient;
    private static final String baseUrl = "http://api.aviationstack.com/v1/flights";

    public FlightRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    public String getArrivingFlights(String iataAirportCode){

        return "flight code is "+iataAirportCode;
    }
}
