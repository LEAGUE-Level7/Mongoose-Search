package org.jointheleague.level7.MongooseSearch.presentation;

import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {
private FlightController flightController;
@Mock
private FlightService flightService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightController = new FlightController(flightService);
    }

    @Test
    void whenGetArrivingFlights_thenReturnListOfResults() {
        //given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedArrivingFlights = new AviationStackResponse();

        when(flightService.getArrivingFlights(iataAirportCode))
        .thenReturn(expectedArrivingFlights);
        //when
        AviationStackResponse actualArrivingFlights = flightController.getArrivingFlights(iataAirportCode);
        //then
        assertEquals(expectedArrivingFlights, actualArrivingFlights);
    }

    @Test
    void whenGetDepartingFlights_thenReturnListOfResults() {
        //given
        String iataAirportCode = "SAN";
        AviationStackResponse expectedDepartingFlights = new AviationStackResponse();

        when(flightService.getDepartingFlights(iataAirportCode))
                .thenReturn(expectedDepartingFlights);
        //when
        AviationStackResponse actualDepartingFlights = flightController.getDepartingFlights(iataAirportCode);
        //then
        assertEquals(expectedDepartingFlights, actualDepartingFlights);
    }
}