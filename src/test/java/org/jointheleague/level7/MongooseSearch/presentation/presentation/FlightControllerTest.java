package org.jointheleague.level7.MongooseSearch.presentation.presentation;

import org.jointheleague.level7.MongooseSearch.presentation.FlightController;
import org.jointheleague.level7.MongooseSearch.repository.dto.AviationStackResponse;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {
    private FlightController flightController;
    @Mock // creates a mock flight service
    private FlightService flightService;

    @BeforeEach
    void setUp() {
        // mock - fake flight service
        MockitoAnnotations.openMocks(this); // test class in which we want to initialize the mock

        flightController = new FlightController(flightService);
    }

    @Test
    void whenGetArrivingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedArrivingFlights = new AviationStackResponse();

            // stubbing -- when() and .thenReturn() from import static org.mockito.Mockito.when;
        when(flightService.getArrivingFlights(iataAirportCode))
                .thenReturn(expectedArrivingFlights);

        // when
        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);

        // then
        assertEquals(expectedArrivingFlights, actualArrivingFlights);
    }

    @Test
    void whenGetDepartingFlights_thenReturnListOfResults() {
        // given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedDepartingFlights = new AviationStackResponse();

            // stubbing
        when(flightService.getDepartingFlights(iataAirportCode))
                .thenReturn(expectedDepartingFlights);

        // when
        AviationStackResponse actualDepartingFlights = flightController.getDepartingFlights(iataAirportCode);

        // then
        assertEquals(expectedDepartingFlights, actualDepartingFlights);
    }
}