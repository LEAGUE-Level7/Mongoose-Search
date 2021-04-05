package org.jointheleague.level7.MongooseSearch.presentation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
@CrossOrigin
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }
    @GetMapping("/arriving")
    @ApiOperation(value="Searches aviationstack for arriving flights at this airport.", response=String.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Flight results found."),
            @ApiResponse(code=404,message="No flight results found.")
    })
    public AviationStackResponse getArrivingFlights(@RequestParam("q") String iataAirportCode){
        return flightService.getArrivingFlights(iataAirportCode);
    }

    @GetMapping("/departing")
    @ApiOperation(value="Searches aviationstack for departing flights from this aiport.", response=String.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Flight results found."),
            @ApiResponse(code=404,message="No flight results found.")

    })
    public AviationStackResponse getDepartingFlights(@RequestParam("q") String iataAirportCode){
        return flightService.getDepartingFlights(iataAirportCode);
    }

}
