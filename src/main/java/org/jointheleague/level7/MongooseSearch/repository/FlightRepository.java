package org.jointheleague.level7.MongooseSearch.repository;

import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class FlightRepository {
    private WebClient webClient;
    private static final String baseUrl= "http://api.aviationstack.com/v1/flights";
    private final String accessKey = "747ca55c8b46ed9f3b1956e6b7eb6394";

    public FlightRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public FlightRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    //http://api.aviationstack.com/v1/flights?access_key=747ca55c8b46ed9f3b1956e6b7eb6394&arr_iata=SAN
    public AviationStackResponse getArrivingFlights(String iataAirportCode){
        Mono<AviationStackResponse> aviationStackResponseMono = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("access_key", accessKey)
                        .queryParam("arr_iata", iataAirportCode)
                        .build())
                .retrieve()
                .bodyToMono(AviationStackResponse.class);
        return aviationStackResponseMono.block();
    }

    public AviationStackResponse getDepartingFlights(String iataAirportCode){
        Mono<AviationStackResponse> aviationStackResponseMono = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("access_key", accessKey)
                        .queryParam("dep_iata", iataAirportCode)
                        .build())
                .retrieve()
                .bodyToMono(AviationStackResponse.class);
        return aviationStackResponseMono.block();
    }


}
