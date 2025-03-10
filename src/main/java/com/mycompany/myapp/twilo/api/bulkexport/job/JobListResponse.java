package com.mycompany.myapp.twilo.api.bulkexport.job;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Inner class to map the job list response
@Getter
@Setter
public class JobListResponse {
    private Meta meta;
    private List<Job> jobs;
}

// Inner class to map individual job response

