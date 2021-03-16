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
                        .queryParam("dep_iata", iataAirportCode) // dep_iata for departure data
                        .build())
                .retrieve()
                .bodyToMono(AviationStackResponse.class);
        return aviationStackResponseMono.block();
    }

    /*
    {
      "flight_date": "2021-02-01",
      "flight_status": "landed",
      "departure": {
        "airport": "Seattle-Tacoma International",
        "iata": "SEA",
      },
      "arrival": {
        "airport": "San Diego International Airport",
        "timezone": "America/Los_Angeles",
        "iata": "SAN",
        "terminal": "2",
        "gate": "20",
        "scheduled": "2021-02-01T14:00:00+00:00",
        "estimated": "2021-02-01T14:00:00+00:00",
        "actual": "2021-02-01T13:56:00+00:00",
      },
      "airline": {
        "name": "Korean Air",
        "iata": "KE",
      },
      "flight": {
        "number": "6125",
        "iata": "KE6125",
        "codeshared": {
          "airline_name": "alaska airlines",
          "flight_iata": "as1478",
        }
      }

    }
     */
}
