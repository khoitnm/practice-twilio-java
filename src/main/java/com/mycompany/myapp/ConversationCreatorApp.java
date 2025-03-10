package com.mycompany.myapp;

import com.mycompany.myapp.twilo.api.TwilioConversationSdk;
import com.mycompany.myapp.twilo.api.bulkexport.ExportResourceTypeTwDto;
import com.mycompany.myapp.twilo.api.bulkexport.jobstatus.ExportJobStatusTwDto;
import com.mycompany.myapp.twilo.api.bulkexport.jobstatus.TwilioGetBulkExportJobSdk;

import java.io.IOException;

public class ConversationCreatorApp {
    public static void main(String[] args) throws IOException {
        TwilioConversationSdk.createConversations();
//        TwilioBulkExportSdk.createExportJob(ExportJobRequestTwDto.builder()
//                .resourceType(ExportResourceTypeTwDto.Messages)
//                .startDate("2025-01-01")
//                .endDate("2025-03-08")
//                .build());

        ExportJobStatusTwDto jobStatus = TwilioGetBulkExportJobSdk.getExportJobStatus(ExportResourceTypeTwDto.Messages, "JSb954076a1c6797a5553b8dd9c85d1472");
        System.out.println("Job Status: " + jobStatus.toString());
    }
}  
