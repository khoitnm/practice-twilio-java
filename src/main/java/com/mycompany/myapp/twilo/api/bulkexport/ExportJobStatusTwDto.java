package com.mycompany.myapp.twilo.api.bulkexport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExportJobStatusTwDto {

    @JsonProperty("job_sid")
    private String jobSid;

    @JsonProperty("resource_type")
    private String resourceType;

    @JsonProperty("start_day")
    private String startDay;

    @JsonProperty("end_day")
    private String endDay;

    @JsonProperty("friendly_name")
    private String friendlyName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("details")
    private String details;

    @JsonProperty("estimated_completion_time")
    private String estimatedCompletionTime;

    @JsonProperty("completion_time")
    private String completionTime;

    @JsonProperty("url")
    private String url;
}