package org.jointheleague.level7.MongooseSearch.service;

import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.jointheleague.level7.MongooseSearch.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlightServiceTest {

    private FlightService flightService;
    @Mock
    private FlightRepository flightRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightService = new FlightService(flightRepository);
    }


    @Test
    void getArrivingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedArrivingFlights = new AviationStackResponse();

        when(flightRepository.getArrivingFlights(iataAirportCode))
                .thenReturn(expectedArrivingFlights);
        // when
        AviationStackResponse actualArrivingFlights = flightService.getArrivingFlights(iataAirportCode);
        // then
        assertEquals(expectedArrivingFlights, actualArrivingFlights);
    }

    @Test
    void getDepartingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedDepartingFlights = new AviationStackResponse();

        when(flightRepository.getDepartingFlights(iataAirportCode))
                .thenReturn(expectedDepartingFlights);
        // when
        AviationStackResponse actualDepartingFlights = flightService.getDepartingFlights(iataAirportCode);
        // then
        assertEquals(expectedDepartingFlights, actualDepartingFlights);
    }
}