package org.jointheleague.level7.MongooseSearch.service;

import org.jointheleague.level7.MongooseSearch.presentation.FlightController;
import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlightServiceTest {

    private FlightService flightService;
    @Mock
    private FlightController flightController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightService = new FlightService(flightController);
    }


    @Test
    void getArrivingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedArrivingFlights = new AviationStackResponse();

        when(flightController.getArrivingFlights(iataAirportCode))
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

        when(flightController.getDepartingFlights(iataAirportCode))
                .thenReturn(expectedDepartingFlights);
        // when
        AviationStackResponse actualDepartingFlights = flightService.getDepartingFlights(iataAirportCode);
        // then
        assertEquals(expectedDepartingFlights, actualDepartingFlights);
    }
}