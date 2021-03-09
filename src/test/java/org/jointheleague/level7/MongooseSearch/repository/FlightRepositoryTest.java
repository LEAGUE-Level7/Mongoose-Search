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
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<AviationStackResponse> aviationStackResponseMono;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightRepository = new FlightRepository();
        flightRepository.setWebClient(webClientMock);
    }

    @Test
    void whenGetArrivingFlights_thenReturnAviationStackResponse() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedAviationStackResponse = new AviationStackResponse();
        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri(anyString()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(AviationStackResponse.class))
                .thenReturn(aviationStackResponseMono);
        when(aviationStackResponseMono.block())
                .thenReturn(expectedAviationStackResponse);

        // when
        AviationStackResponse actualAviationStackResponse = flightRepository.getArrivingFlights(iataAirportCode);

        // then
        assertEquals(expectedAviationStackResponse, actualAviationStackResponse);
    }

    @Test
    void getDepartingFlights() {
    }
}