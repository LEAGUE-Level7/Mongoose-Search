package org.jointheleague.level7.MongooseSearch.presentation.presentation;

import org.jointheleague.level7.MongooseSearch.presentation.FlightController;
import org.jointheleague.level7.MongooseSearch.repository.dto.*;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {
    private FlightController flightController;
    @Mock // creates a mock flight service
    private FlightService flightService;
    AviationStackResponse aviationStackResponse;
    private String flightDate;
    private String flightStatus;
    @BeforeEach
    void setUp() {
        // mock - fake flight service
        MockitoAnnotations.openMocks(this); // test class in which we want to initialize the mock

        flightController = new FlightController(flightService);
        aviationStackResponse = new AviationStackResponse();
        flightDate = "flightDate";
        flightStatus = "flightStatus";
        Datum datum = new Datum(flightDate, flightStatus, new Departure(), new Arrival(), new Airline(), new Flight(), new Object(), new Object(), new HashMap<String, Object>());
        aviationStackResponse.setData(List.of(datum));
        when(flightService.getArrivingFlights("SAN"))
                .thenReturn(aviationStackResponse);
        when(flightService.getDepartingFlights("SAN"))
                .thenReturn(aviationStackResponse);
        when(flightService.getArrivingFlights("BadInput"))
                .thenReturn(new AviationStackResponse()) ;
        when(flightService.getDepartingFlights("BadInput"))
                .thenReturn(new AviationStackResponse());
    }

    @Test
    void givenBadInputThen_whenGetArrivingFlights_thenThrowException() {
        // given
        String iataAirportCode = "BadInput";

        // when
        // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(new AviationStackResponse());
        // then
        assertThrows(ResponseStatusException.class, () -> flightController.getArrivingFlights(iataAirportCode));
    }


    @Test
    void givenBadInputThen_whenGetDepartingFlights_thenThrowException() {
        // given
        String iataAirportCode = "BadInput";

        // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(new AviationStackResponse());

        // when

        // then
        assertThrows(ResponseStatusException.class, () -> flightController.getDepartingFlights(iataAirportCode));
    }
    @Test
    void whenGetArrivingFlights_thenReturnResult() {
        // given
        String iataAirportCode = "SAN";
        // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(aviationStackResponse);
        // when
        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);

        // then
       assertEquals(aviationStackResponse, actualArrivingFlights);
    }


    @Test
    void whenGetDepartingFlights_thenReturnResult() {
        // given
        String iataAirportCode = "SAN";

        // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(aviationStackResponse);

        // when
        AviationStackResponse actualDepartingFlights = flightController.getDepartingFlights(iataAirportCode);
        // then
        assertEquals(aviationStackResponse, actualDepartingFlights);
    }
}