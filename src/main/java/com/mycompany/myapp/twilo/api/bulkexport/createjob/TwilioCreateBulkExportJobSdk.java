package com.mycompany.myapp.twilo.api.bulkexport.createjob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.twilo.api.bulkexport.TwilioSdkHelper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TwilioCreateBulkExportJobSdk {


    private static final String BASE_URL = "https://bulkexports.twilio.com/v1/Exports";

    public static ExportJobResponseTwDto createExportJob(
            String resourceType, String startDay, String endDay, String friendlyName, String email
    ) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL + "/" + resourceType + "/Jobs");
        TwilioSdkHelper.setHttpAuthorizationHeaders(httpPost);

        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        String body = String.format(
                "StartDay=%s&FriendlyName=%s",
                startDay, friendlyName
        );
        if (endDay != null) {
            body += "&EndDay=" + endDay;
        }
        if (email != null) {
            body += "&Email=" + email;
        }
        httpPost.setEntity(new StringEntity(body));

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println("\tResponse: " + jsonResponse);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, ExportJobResponseTwDto.class);
        }
    }

    public static ExportJobResponseTwDto createExportJob(ExportJobRequestTwDto request) throws IOException {
        ExportJobResponseTwDto response = createExportJob(
                request.getResourceType().toString(),
                request.getStartDate(),
                request.getEndDate(),
                "JobTest_" + request.getStartDate() + "_" + request.getEndDate(),
                request.getEmail()

        );
        System.out.println("Created Export Job: " + response.toString());
        return response;
    }
}