package org.jointheleague.level7.MongooseSearch.presentation;

import org.jointheleague.level7.MongooseSearch.repository.DTO.*;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(FlightController.class)
public class FlightControllerIntTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FlightService flightService;
    AviationStackResponse aviationStackResponse;
    private String flightDate;
    private String flightStatus;

    @BeforeEach
    void setUp(){
        aviationStackResponse = new AviationStackResponse();
        flightDate = "flightDate";
        flightStatus = "flightStatus";
        Datum datum = new Datum(flightDate, flightStatus, new Departure(), new Arrival(), new Airline(), new Flight(), new Object(), new Object(), new HashMap<String, Object>());
        aviationStackResponse.setData(List.of(datum));
        when(flightService.getArrivingFlights("SAN"))
                .thenReturn(aviationStackResponse);
        when(flightService.getDepartingFlights("SAN"))
                .thenReturn(aviationStackResponse);
        when(flightService.getArrivingFlights("hiMyNameIsBob"))
                .thenReturn(new AviationStackResponse());
        when(flightService.getDepartingFlights("hiMyNameIsBob"))
                .thenReturn(new AviationStackResponse());
    }

    @Test
    void whenGetArrivingFlights_thenIsOkayAndReturnsResults() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/flights/arriving?q=SAN"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].flight_date", is(flightDate)))
                .andExpect(jsonPath("$.data.[0].flight_status", is(flightStatus)))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    void whenGetDepartingFlights_thenIsOkayAndReturnsResults() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/flights/departing?q=SAN"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].flight_date", is(flightDate)))
                .andExpect(jsonPath("$.data.[0].flight_status", is(flightStatus)))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    void giveBadQuery_whenGetDepartingFlights_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/flights/departing?q=hiMyNameIsBob"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void giveBadQuery_whenGetArrivingFlights_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/flights/arriving?q=hiMyNameIsBob"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
