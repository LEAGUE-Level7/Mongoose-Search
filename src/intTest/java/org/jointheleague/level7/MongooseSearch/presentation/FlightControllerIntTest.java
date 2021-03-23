package org.jointheleague.level7.MongooseSearch.presentation;

import org.jointheleague.level7.MongooseSearch.repository.DTO.*;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebMvcTest(FlightController.class)


public class FlightControllerIntTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FlightService flightService;
    @BeforeEach
    void setUp(){
        AviationStackResponse aviationStackResponse = new AviationStackResponse();
        Datum datum = new Datum("flightDate", "flightStatus", new Departure(), new Arrival(), new Airline(), new Flight(), new Object(), new Object(), new HashMap<String, Object>());
        aviationStackResponse.setData(List.of(datum));
    }
}
