package org.jointheleague.level7.MongooseSearch.presentation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @GetMapping("/arriving")
    @ApiOperation(value="searches aviationstack for arriving flights at a certain airport", response=String.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "flight(s) were found"),
            @ApiResponse(code = 404, message = "flight(s) not found")
    })
    public String getArrivingFlights(@RequestParam("q") String iataAirportCode){
        return "The Airport code " + iataAirportCode;
    }
}
