package org.jointheleague.level7.MongooseSearch.repository;

import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Repository
public class FlightRepository {
    private final WebClient webClient;
    private static final String baseUrl = "http://api.aviationstack.com/v1/flights";
    private final String accessKey = "747ca55c8b46ed9f3b1956e6b7eb6394";

    public FlightRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    public String getArrivingFlights(String iataAirportCode){
        Mono<String> stringMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("access_key", accessKey)
                        .queryParam("arr_iata",iataAirportCode)
                        .build()
                ).retrieve()
                .bodyToMono(String.class);
        return stringMono.block();
    }
}
