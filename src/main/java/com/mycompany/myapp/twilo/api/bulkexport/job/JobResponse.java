package com.mycompany.myapp.twilo.api.bulkexport.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter @Getter
public class JobResponse {
    @JsonProperty("estimated_completion_time")
    private Date estimatedCompletionTime;

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
}