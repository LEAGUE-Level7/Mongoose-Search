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
    @ApiOperation(value="Searches aviationstack for arriving flights at this airport.", response=String.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Flight results found."),
            @ApiResponse(code=404,message="No flight results found.")
    })
    public String getArrivingFlights(@RequestParam("q") String iataAirportCode){
        return "The airport code of the requested airport is "+iataAirportCode;
    }

}
