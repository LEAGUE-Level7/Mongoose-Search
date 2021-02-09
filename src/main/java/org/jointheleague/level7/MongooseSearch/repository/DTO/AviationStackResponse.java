
package org.jointheleague.level7.MongooseSearch.repository.DTO;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flight_date",
    "flight_status",
    "departure",
    "arrival",
    "airline",
    "flight"
})
public class AviationStackResponse {

    @JsonProperty("flight_date")
    private String flightDate;
    @JsonProperty("flight_status")
    private String flightStatus;
    @JsonProperty("departure")
    private Departure departure;
    @JsonProperty("arrival")
    private Arrival arrival;
    @JsonProperty("airline")
    private Airline airline;
    @JsonProperty("flight")
    private Flight flight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flight_date")
    public String getFlightDate() {
        return flightDate;
    }

    @JsonProperty("flight_date")
    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    @JsonProperty("flight_status")
    public String getFlightStatus() {
        return flightStatus;
    }

    @JsonProperty("flight_status")
    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    @JsonProperty("departure")
    public Departure getDeparture() {
        return departure;
    }

    @JsonProperty("departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    @JsonProperty("arrival")
    public Arrival getArrival() {
        return arrival;
    }

    @JsonProperty("arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("airline")
    public Airline getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @JsonProperty("flight")
    public Flight getFlight() {
        return flight;
    }

    @JsonProperty("flight")
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
