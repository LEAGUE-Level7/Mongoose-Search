package org.jointheleague.level7.MongooseSearch.repository.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({ "aircraft", "live" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flight_date",
    "flight_status",
    "departure",
    "arrival",
    "airline",
    "flight",
    "aircraft",
    "live"
})
public class Datum {

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
    @JsonProperty("aircraft")
    private Object aircraft;
    @JsonProperty("live")
    private Object live;

    public Datum(String flightDate, String flightStatus, Departure departure, Arrival arrival, Airline airline, Flight flight, Object aircraft, Object live, Map<String, Object> additionalProperties) {
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.departure = departure;
        this.arrival = arrival;
        this.airline = airline;
        this.flight = flight;
        this.aircraft = aircraft;
        this.live = live;
        this.additionalProperties = additionalProperties;
    }

    public Datum() {

    }

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

    @JsonProperty("aircraft")
    public Object getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(Object aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("live")
    public Object getLive() {
        return live;
    }

    @JsonProperty("live")
    public void setLive(Object live) {
        this.live = live;
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
