package com.mycompany.myapp.twilo.api.bulkexport.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Job {
    @JsonProperty("start_day")
    private String startDay;

    @JsonProperty("estimated_completion_time")
    private Date estimatedCompletionTime;

    @JsonProperty("job_sid")
    private String jobSid;

    @JsonProperty("job_queue_position")
    private String jobQueuePosition;

    @JsonProperty("friendly_name")
    private String friendlyName;

    @JsonProperty("webhook_method")
    private String webhookMethod;

    private List<JobDetail> details;

    @JsonProperty("end_day")
    private String endDay;

    @JsonProperty("webhook_url")
    private String webhookUrl;

    private String email;

    @JsonProperty("resource_type")
    private String resourceType;
}