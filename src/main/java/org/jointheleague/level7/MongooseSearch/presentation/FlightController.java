package org.jointheleague.level7.MongooseSearch.presentation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jointheleague.level7.MongooseSearch.repository.DTO.AviationStackResponse;
import org.jointheleague.level7.MongooseSearch.repository.DTO.Flight;
import org.jointheleague.level7.MongooseSearch.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/flights")

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
        AviationStackResponse arrivingFlights = flightService.getArrivingFlights(iataAirportCode);
       if(CollectionUtils.isEmpty(arrivingFlights.getData())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No flights Found.");
       }
        return arrivingFlights;
    }
    @GetMapping("/departing")
    @ApiOperation(value="Searches aviationstack for departing flights at this airport.", response=String.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Flight results found."),
            @ApiResponse(code=404,message="No flight results found.")
    })

    public AviationStackResponse getDepartingFlights(@RequestParam("q") String iataAirportCode){
        AviationStackResponse departingFlights = flightService.getDepartingFlights(iataAirportCode);
        if(CollectionUtils.isEmpty(departingFlights.getData())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No flight results found.");
        }
        return flightService.getDepartingFlights(iataAirportCode);
    }

}
