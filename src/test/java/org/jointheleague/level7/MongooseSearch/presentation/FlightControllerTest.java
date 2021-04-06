package org.jointheleague.level7.MongooseSearch.presentation;

import org.jointheleague.level7.MongooseSearch.repository.DTO.*;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {
    private FlightController flightController;
    @Mock
    private FlightService flightService;

    AviationStackResponse aviationStackResponse;
    private String flightDate;
    private String flightStatus;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        aviationStackResponse = new AviationStackResponse();
        flightDate = "flightDate";
        flightStatus = "flightStatus";
        Datum datum = new Datum(flightDate, flightStatus, new Departure(), new Arrival(), new Airline(), new Flight(), new Object(), new Object(), new HashMap<String, Object>());
        aviationStackResponse.setData(List.of(datum));
        flightController = new FlightController(flightService);
    }
    @Test
    void whenGetArrivingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";


        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(aviationStackResponse);
        // when
        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);
        // then
        assertEquals(aviationStackResponse, actualArrivingFlights);
    }

    @Test
    void givenBadInput_whenGetArrivingFlights_thenThrowsException() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedArrivingFlights = new AviationStackResponse();

        when(flightService.getArrivingFlights(iataAirportCode))
        .thenReturn(expectedArrivingFlights);
        // when

        // then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> flightController.getArrivingFlights(iataAirportCode));


    }

    @Test
    void givenBadInput_whenGetDepartingFlights_thenThrowsException() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedDepartingFlights = new AviationStackResponse();

        when(flightService.getDepartingFlights(iataAirportCode))
                .thenReturn(expectedDepartingFlights);
        // when

        // then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> flightController.getDepartingFlights(iataAirportCode));
    }
    @Test
    void  whenGetDepartingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";


        when(flightService.getDepartingFlights(iataAirportCode))
                .thenReturn(aviationStackResponse);
        // when
        AviationStackResponse actualDepartingFlights = flightController.getDepartingFlights(iataAirportCode);
        // then
        assertEquals(aviationStackResponse, actualDepartingFlights);
    }
}