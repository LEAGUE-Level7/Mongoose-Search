
package org.jointheleague.level7.MongooseSearch.repository.dto;

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
    "airline_name",
    "flight_iata"
})
public class Codeshared {

    @JsonProperty("airline_name")
    private String airlineName;
    @JsonProperty("flight_iata")
    private String flightIata;
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

    @JsonProperty("flight_iata")
    public String getFlightIata() {
        return flightIata;
    }

    @JsonProperty("flight_iata")
    public void setFlightIata(String flightIata) {
        this.flightIata = flightIata;
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
