
package org.jointheleague.level7.MongooseSearch.repository.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AviationStackResponse {

    @JsonProperty("pagination")

    private Pagination pagination;
    @JsonProperty("data")

    private List<Datum> data = null;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
