
package org.jointheleague.level7.MongooseSearch.repository.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Departure {

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

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public Object getTerminal() {
        return terminal;
    }

    public void setTerminal(Object terminal) {
        this.terminal = terminal;
    }

    public Object getGate() {
        return gate;
    }

    public void setGate(Object gate) {
        this.gate = gate;
    }

    public Object getDelay() {
        return delay;
    }

    public void setDelay(Object delay) {
        this.delay = delay;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public Object getActual() {
        return actual;
    }

    public void setActual(Object actual) {
        this.actual = actual;
    }

    public Object getEstimatedRunway() {
        return estimatedRunway;
    }

    public void setEstimatedRunway(Object estimatedRunway) {
        this.estimatedRunway = estimatedRunway;
    }

    public Object getActualRunway() {
        return actualRunway;
    }

    public void setActualRunway(Object actualRunway) {
        this.actualRunway = actualRunway;
    }

}
