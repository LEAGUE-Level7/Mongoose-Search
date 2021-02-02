
package org.jointheleague.level7.MongooseSearch.repository.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Pagination {

    @JsonProperty("limit")

    private Integer limit;
    @JsonProperty("offset")

    private Integer offset;
    @JsonProperty("count")

    private Integer count;
    @JsonProperty("total")

    private Integer total;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
