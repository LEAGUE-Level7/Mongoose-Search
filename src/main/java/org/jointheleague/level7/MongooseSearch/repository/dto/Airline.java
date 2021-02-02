
package org.jointheleague.level7.MongooseSearch.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airline {

    @JsonProperty("name")

    private String name;
    @JsonProperty("iata")

    private String iata;
    @JsonProperty("icao")

    private String icao;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
