package org.jointheleague.level7.MongooseSearch.repository;

import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

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
    Mono<AviationStackResponse> AviationStackMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightRepository = new FlightRepository(webClientMock);
    }

    @Test
    void whenGetArrivingFlights_thenReturnAviationStackResponse() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedAviationStackResponse = new AviationStackResponse();
        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(AviationStackResponse.class))
                .thenReturn(AviationStackMonoMock);
        when(AviationStackMonoMock.block())
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