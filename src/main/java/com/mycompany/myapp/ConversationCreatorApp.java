package com.mycompany.myapp;

import com.mycompany.myapp.twilo.api.TwilioConversationSdk;
import com.mycompany.myapp.twilo.api.bulkexport.ExportResourceTypeTwDto;
import com.mycompany.myapp.twilo.api.bulkexport.download.TwilioJobDownloadSdkV1;
import com.mycompany.myapp.twilo.api.bulkexport.download.TwilioJobStatusSdkV2;
import com.mycompany.myapp.twilo.api.bulkexport.job.JobListResponse;
import com.mycompany.myapp.twilo.api.bulkexport.job.TwilioListJobsSdk;

import java.io.IOException;

public class ConversationCreatorApp {
    public static void main(String[] args) throws IOException {
        ExportResourceTypeTwDto resourceType = ExportResourceTypeTwDto.Messages;
        TwilioConversationSdk.createConversations();
        JobListResponse jobs = TwilioListJobsSdk.listJobs(resourceType);

        String jobSid = jobs.getJobs().get(0).getJobSid();
        TwilioJobStatusSdkV2.getJobData(jobSid);
//        TwilioCreateBulkExportJobSdk.createExportJob(ExportJobRequestTwDto.builder()
//                .resourceType(resourceType)
//                .startDate("2025-01-01")
//                .endDate("2025-03-08")
//                .build());

//        ExportJobStatusTwDto jobStatus = TwilioGetBulkExportJobSdk.getExportJobStatus(resourceType, "JSb954076a1c6797a5553b8dd9c85d1472");
//        System.out.println("Job Status: " + jobStatus.toString());
        String jobData = TwilioJobDownloadSdkV1.downloadMessages( jobSid);
        System.out.println("Job Data: " + jobData.toString());

    }
}  
