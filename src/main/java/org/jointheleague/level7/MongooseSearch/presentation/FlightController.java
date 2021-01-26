package org.jointheleague.level7.MongooseSearch.presentation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jointheleague.level7.MongooseSearch.presentation.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // class will actually return data(special version of controller)
@RequestMapping("/flights") // class-level annotation
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService; // for initialization of flightService member variables
    }

    @GetMapping("/arriving") // method-level annotation (special version of request mapping)
    @ApiOperation(value="searches aviationstack for arriving flights at a certain airport", response=String.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "flight(s) were found"),
            @ApiResponse(code = 404, message = "flight(s) not found")
    })
    public String getArrivingFlights(@RequestParam("q") String iataAirportCode){
        return flightService.getArrivingFlights(iataAirportCode);
    }
}
