package org.jointheleague.level7.MongooseSearch.repository.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({
        "icao",
        "baggage",
        "delay",
        "estimated_runway",
        "actual_runway" })
@JsonPropertyOrder({
    "airport",
    "timezone",
    "iata",
    "icao",
    "terminal",
    "gate",
    "baggage",
    "delay",
    "scheduled",
    "estimated",
    "actual",
    "estimated_runway",
    "actual_runway"
})
public class Arrival {

    @JsonProperty("airport")
    private String airport;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("iata")
    private String iata;
    @JsonProperty("icao")
    private String icao;
    @JsonProperty("terminal")
    private Object terminal;
    @JsonProperty("gate")
    private Object gate;
    @JsonProperty("baggage")
    private Object baggage;
    @JsonProperty("delay")
    private Object delay;
    @JsonProperty("scheduled")
    private String scheduled;
    @JsonProperty("estimated")
    private String estimated;
    @JsonProperty("actual")
    private Object actual;
    @JsonProperty("estimated_runway")
    private Object estimatedRunway;
    @JsonProperty("actual_runway")
    private Object actualRunway;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("airport")
    public String getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(String airport) {
        this.airport = airport;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("iata")
    public String getIata() {
        return iata;
    }

    @JsonProperty("iata")
    public void setIata(String iata) {
        this.iata = iata;
    }

    @JsonProperty("icao")
    public String getIcao() {
        return icao;
    }

    @JsonProperty("icao")
    public void setIcao(String icao) {
        this.icao = icao;
    }

    @JsonProperty("terminal")
    public Object getTerminal() {
        return terminal;
    }

    @JsonProperty("terminal")
    public void setTerminal(Object terminal) {
        this.terminal = terminal;
    }

    @JsonProperty("gate")
    public Object getGate() {
        return gate;
    }

    @JsonProperty("gate")
    public void setGate(Object gate) {
        this.gate = gate;
    }

    @JsonProperty("baggage")
    public Object getBaggage() {
        return baggage;
    }

    @JsonProperty("baggage")
    public void setBaggage(Object baggage) {
        this.baggage = baggage;
    }

    @JsonProperty("delay")
    public Object getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(Object delay) {
        this.delay = delay;
    }

    @JsonProperty("scheduled")
    public String getScheduled() {
        return scheduled;
    }

    @JsonProperty("scheduled")
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    @JsonProperty("estimated")
    public String getEstimated() {
        return estimated;
    }

    @JsonProperty("estimated")
    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    @JsonProperty("actual")
    public Object getActual() {
        return actual;
    }

    @JsonProperty("actual")
    public void setActual(Object actual) {
        this.actual = actual;
    }

    @JsonProperty("estimated_runway")
    public Object getEstimatedRunway() {
        return estimatedRunway;
    }

    @JsonProperty("estimated_runway")
    public void setEstimatedRunway(Object estimatedRunway) {
        this.estimatedRunway = estimatedRunway;
    }

    @JsonProperty("actual_runway")
    public Object getActualRunway() {
        return actualRunway;
    }

    @JsonProperty("actual_runway")
    public void setActualRunway(Object actualRunway) {
        this.actualRunway = actualRunway;
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
