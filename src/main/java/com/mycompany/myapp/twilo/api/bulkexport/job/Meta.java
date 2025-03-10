package com.mycompany.myapp.twilo.api.bulkexport.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta {
    private int page;
    @JsonProperty("page_size")
    private int pageSize;

    @JsonProperty("first_page_url")
    private String firstPageUrl;

    @JsonProperty("previous_page_url")
    private String previousPageUrl;

    private String url;

    @JsonProperty("next_page_url")
    private String nextPageUrl;
    private String key;
}