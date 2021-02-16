
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
    "airport",
    "timezone",
    "iata",
    "terminal",
    "gate",
    "scheduled",
    "estimated",
    "actual"
})
public class Arrival {

    @JsonProperty("airport")
    private String airport;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("iata")
    private String iata;
    @JsonProperty("terminal")
    private String terminal;
    @JsonProperty("gate")
    private String gate;
    @JsonProperty("scheduled")
    private String scheduled;
    @JsonProperty("estimated")
    private String estimated;
    @JsonProperty("actual")
    private String actual;
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

    @JsonProperty("terminal")
    public String getTerminal() {
        return terminal;
    }

    @JsonProperty("terminal")
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @JsonProperty("gate")
    public String getGate() {
        return gate;
    }

    @JsonProperty("gate")
    public void setGate(String gate) {
        this.gate = gate;
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
    public String getActual() {
        return actual;
    }

    @JsonProperty("actual")
    public void setActual(String actual) {
        this.actual = actual;
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
