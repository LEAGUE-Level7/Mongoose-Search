package org.jointheleague.level7.MongooseSearch.repository;


import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class FlightRepository {

    private final WebClient webClient;
    private final String baseUrl;
    private final String accessKey = "747ca55c8b46ed9f3b1956e6b7eb6394";


    public FlightRepository() {
        baseUrl = "http://api.aviationstack.com/v1/flights?";
        webClient = WebClient // initializes WebClient in constructor
                .builder() // builds webClient
                .baseUrl(baseUrl) // specifies URL
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // Content header things
                .build(); // builds webClient
    }
    //http://api.aviationstack.com/v1/flights?access_key=747ca55c8b46ed9f3b1956e6b7eb6394&arr_iata=SAN
    public AviationStackResponse getArrivingFlights(String iataAirportCode){
        Mono<AviationStackResponse> aviationStackResponseMono = webClient.get()
                .uri(uriBuilder -> uriBuilder // updates uri with the paramaters that we need for stuff
                        .queryParam("access_key", accessKey)
                        .queryParam("&arr_iata", iataAirportCode)
                        .build()
                ).retrieve()
                .bodyToMono(AviationStackResponse.class); // allows synchronous request(I think)
        return aviationStackResponseMono.block(); // waits for the request to complete

    }
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
