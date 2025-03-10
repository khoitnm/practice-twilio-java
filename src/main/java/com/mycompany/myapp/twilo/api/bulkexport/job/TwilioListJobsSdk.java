package com.mycompany.myapp.twilo.api.bulkexport.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.twilo.api.bulkexport.ExportResourceTypeTwDto;
import com.mycompany.myapp.twilo.api.bulkexport.TwilioSdkHelper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class TwilioListJobsSdk {
    public static JobListResponse listJobs(ExportResourceTypeTwDto resourceType) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://bulkexports.twilio.com/v1/Exports/%s/Jobs".formatted(resourceType));
        TwilioSdkHelper.setHttpAuthorizationHeaders(httpGet);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println("List of Jobs:\n\t" + jsonResponse);
            ObjectMapper objectMapper = new ObjectMapper();
            JobListResponse jobListResponse = objectMapper.readValue(jsonResponse, JobListResponse.class);
            return jobListResponse;
        }
    }
}