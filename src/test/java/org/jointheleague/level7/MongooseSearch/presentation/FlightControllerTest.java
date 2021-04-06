package org.jointheleague.level7.MongooseSearch.presentation;

import org.jointheleague.level7.MongooseSearch.presentation.FlightController;
import org.jointheleague.level7.MongooseSearch.repository.DTO.*;
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

        aviationStackResponse = new AviationStackResponse();
        // sample datum (pl. data)
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

            // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(aviationStackResponse);

        // when
        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);

        // then
        assertEquals(aviationStackResponse, actualArrivingFlights);
    }

    @Test
    void whenGetDepartingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";

            // stubbing
        when(flightService.getDepartingFlights(iataAirportCode))
                .thenReturn(aviationStackResponse);

        // when
        AviationStackResponse actualDepartingFlights = flightController.getDepartingFlights(iataAirportCode);

        // then
        assertEquals(aviationStackResponse, actualDepartingFlights);
    }

    @Test
    void givenBadInput_whenGetArrivingFlights_thenThrowException() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedArrivingFlights = new AviationStackResponse();

        // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(expectedArrivingFlights);

        // when
//        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);

        // then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> flightController.getArrivingFlights(iataAirportCode));
//        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND No flight results found.");
    }

    @Test
    void givenBadInput_whenGetDepartingFlights_thenThrowException() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedDepartingFlights = new AviationStackResponse();

        // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getDepartingFlights(iataAirportCode))
                .thenReturn(expectedDepartingFlights);

        // when
//        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);

        // then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> flightController.getDepartingFlights(iataAirportCode));
//        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND No flight results found.");
    }
}