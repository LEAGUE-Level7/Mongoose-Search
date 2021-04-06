package org.jointheleague.level7.MongooseSearch.presentation;


import org.jointheleague.level7.MongooseSearch.repository.dto.*;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


import java.util.HashMap;
import java.util.List;

@WebMvcTest(FlightController.class)


public class FlightControllerIntTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FlightService flightService;
    AviationStackResponse aviationStackResponse;
    private String flightDate;
    private String flightStatus;
    private Departure departure;

    @BeforeEach
    void setUp(){
        aviationStackResponse = new AviationStackResponse();
        flightDate = "flightDate";
        flightStatus = "flightStatus";
        departure = new Departure();
        Datum datum = new Datum(flightDate, flightStatus, departure, new Arrival(), new Airline(), new Flight(), new Object(), new Object(), new HashMap<String, Object>());
        aviationStackResponse.setData(List.of(datum));
        when (flightService.getArrivingFlights("SAN")).thenReturn(aviationStackResponse);
        when (flightService.getDepartingFlights("SAN")).thenReturn(aviationStackResponse);
        when (flightService.getArrivingFlights("BadInput")).thenReturn(new AviationStackResponse());
        when (flightService.getDepartingFlights("BadInput")).thenReturn(new AviationStackResponse());
    }
    @Test
    void whenGetArrivingFlights_thenIsOkayAndReturnsResults() throws Exception {
       MvcResult mvcResult= mockMvc.perform(get("/flights/arriving?q=SAN"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data[0].flight_date", is(flightDate)))
            .andExpect(jsonPath("$.data[0].flight_status", is(flightStatus)))
            .andReturn();
       assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    void whenGetDepartingFlights_thenIsOkayAndReturnsResults() throws Exception {
        MvcResult mvcResult= mockMvc.perform(get("/flights/departing?q=SAN"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].flight_date", is(flightDate)))
                .andExpect(jsonPath("$.data[0].flight_status", is(flightStatus)))
                .andReturn();
        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }
    @Test
    void givenBadQuery_whenGetArrivingFlights_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/flights/arriving?q=BadInput"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    void givenBadQuery_whenGetDepartingFlights_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/flights/departing?q=BadInput"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
