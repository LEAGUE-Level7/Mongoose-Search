package org.jointheleague.level7.MongooseSearch.repository.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({
        "airline_icao",
        "flight_icao"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "airline_name",
    "airline_iata",
    "airline_icao",
    "flight_number",
    "flight_iata",
    "flight_icao"
})
public class Codeshared {

    @JsonProperty("airline_name")
    private String airlineName;
    @JsonProperty("airline_iata")
    private String airlineIata;
    @JsonProperty("airline_icao")
    private String airlineIcao;
    @JsonProperty("flight_number")
    private String flightNumber;
    @JsonProperty("flight_iata")
    private String flightIata;
    @JsonProperty("flight_icao")
    private String flightIcao;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("airline_name")
    public String getAirlineName() {
        return airlineName;
    }

    @JsonProperty("airline_name")
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @JsonProperty("airline_iata")
    public String getAirlineIata() {
        return airlineIata;
    }

    @JsonProperty("airline_iata")
    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    @JsonProperty("airline_icao")
    public String getAirlineIcao() {
        return airlineIcao;
    }

    @JsonProperty("airline_icao")
    public void setAirlineIcao(String airlineIcao) {
        this.airlineIcao = airlineIcao;
    }

    @JsonProperty("flight_number")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("flight_number")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("flight_iata")
    public String getFlightIata() {
        return flightIata;
    }

    @JsonProperty("flight_iata")
    public void setFlightIata(String flightIata) {
        this.flightIata = flightIata;
    }

    @JsonProperty("flight_icao")
    public String getFlightIcao() {
        return flightIcao;
    }

    @JsonProperty("flight_icao")
    public void setFlightIcao(String flightIcao) {
        this.flightIcao = flightIcao;
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
