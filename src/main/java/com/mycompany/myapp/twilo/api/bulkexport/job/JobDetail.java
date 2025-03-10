package com.mycompany.myapp.twilo.api.bulkexport.job;

import lombok.Data;

import java.util.List;

@Data
public class JobDetail {
    private String status;
    private int count;
    private List<String> days;
}