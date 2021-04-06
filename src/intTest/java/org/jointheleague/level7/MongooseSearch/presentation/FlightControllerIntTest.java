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

import java.awt.*;
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
    @MockBean //
    private FlightService flightService;
    AviationStackResponse aviationStackResponse;
    private String flightDate;
    private String flightStatus;

    @BeforeEach
    void setUp(){
        aviationStackResponse = new AviationStackResponse();
        // sample datum (pl. data)
        flightDate = "flightDate";
        flightStatus = "flightStatus";
        Datum datum = new Datum(flightDate, flightStatus, new Departure(), new Arrival(), new Airline(), new Flight(), new Object(), new Object(), new HashMap<String, Object>());
        aviationStackResponse.setData(List.of(datum));

        when (flightService.getArrivingFlights("SAN")).thenReturn(aviationStackResponse);
        when (flightService.getDepartingFlights("SAN")).thenReturn(aviationStackResponse);
        when (flightService.getArrivingFlights("TYPO")).thenReturn(new AviationStackResponse());
        when (flightService.getDepartingFlights("TYPO")).thenReturn(new AviationStackResponse());
    }

    @Test
    void whenGetArrivingFlights_thenIsOkayAndReturnsResults() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/flights/arriving?q=SAN")) //makes the request --> request URI = "/"
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].flight_date", is(flightDate)))
                .andExpect(jsonPath("$.data[0].flight_status", is(flightStatus)))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    void whenGetDepartingFlights_thenIsOkayAndReturnsResults() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/flights/departing?q=SAN")) //makes the request --> request URI = "/"
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].flight_date", is(flightDate)))
                .andExpect(jsonPath("$.data[0].flight_status", is(flightStatus)))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    void givenBadQuery_whenGetArrivingFlights_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/flights/arriving?q=TYPO")) //makes the request --> request URI = "/"
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void givenBadQuery_whenGetDepartingFlights_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/flights/departing?q=TYPO")) //makes the request --> request URI = "/"
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    // waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting
    // waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting
    // waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting
    // waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting waiting
    // tediously waiting every day of my life to get rejected from mit

    // loading loading loading loading loading loading loading loading loading loading loading loading loading loading
    // YAYYYYYYYYYYYY

    // dum dum dum dunnnnnnnnnn dum dudum dudum dudum dunnnnnnnn
    // dun dun dun dun dun dun dun dun dun dun dun dun dooooooo dooooooooo doooooooooooooooooo
    // DUN DUNNNNNNNNNNN

    // my code is sick but there's a typo, an itty bitty typo, and now there are angry red lines all over my code.
    // you might think it's a bit crazy, i know it seems crazy, but i swear there are angry red lines all over my code.
    // flip, i also forgot a semicolon at the end of my statement, and now java is getting mad at me-e.
    // things are getting kinda crazy, there're too many classes, and springframe is not cooperating,
    // my code is sick but there's a typo, and a missing semicolon, but at least i don't have to worry about payments.


}
