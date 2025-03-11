package com.mycompany.myapp.twilo.api.bulkexport.createjob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExportJobResponseTwDto {

    @JsonProperty("start_day")
    private String startDay;

    @JsonProperty("estimated_completion_time")
    private String estimatedCompletionTime;

    @JsonProperty("job_sid")
    private String jobSid;

    @JsonProperty("job_queue_position")
    private String jobQueuePosition;

    @JsonProperty("friendly_name")
    private String friendlyName;

    @JsonProperty("webhook_method")
    private String webhookMethod;

    @JsonProperty("details")
    private String details;

    @JsonProperty("end_day")
    private String endDay;

    @JsonProperty("webhook_url")
    private String webhookUrl;

    @JsonProperty("email")
    private String email;

    @JsonProperty("resource_type")
    private String resourceType;
}