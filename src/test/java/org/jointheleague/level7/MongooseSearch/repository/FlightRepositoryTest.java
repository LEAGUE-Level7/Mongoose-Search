package org.jointheleague.level7.MongooseSearch.repository;

import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class FlightRepositoryTest {
    private FlightRepository flightRepository;
    @Mock
    private WebClient webClient;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    WebClient.ResponseSpec responseSpec;
    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<AviationStackResponse> AviationStackResponseMonoMock;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightRepository = new FlightRepository();
        flightRepository.setWebClient(webClient);
    }

    @Test
    void whenGetArrivingFlights_thenReturnAviationStackResponse() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedAviationStackResponse = new AviationStackResponse();
        flightRepository.getArrivingFlights(iataAirportCode);
        when(webClient.get())
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString()))
                .thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve())
                .thenReturn(responseSpec);
        when(responseSpec.bodyToMono(AviationStackResponse.class))
                .thenReturn(Mono.just(expectedAviationStackResponse));
        // when
       AviationStackResponse actualAviationStackResponse = flightRepository.getArrivingFlights(iataAirportCode);

        // then
        assertEquals(expectedAviationStackResponse,actualAviationStackResponse);
    }

    @Test
    void getDepartingFlights() {
    }

}