package org.jointheleague.level7.MongooseSearch.repository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class FlightRepository { // request to aviation stack
    private final WebClient webClient; // needed to facilitate request to aviation stack
    private static final String baseUrl = "http://api.aviationstack.com/v1/flights";

    public FlightRepository() { // initialization constructor
        webClient = WebClient
                .builder() //build webclient
                .baseUrl(baseUrl) //specifies url
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) //content header stuff
                .build(); //
    }

    public String getArrivingFlights(String iataAirportCode){
        return "Repo code: " + iataAirportCode;
    }
}
