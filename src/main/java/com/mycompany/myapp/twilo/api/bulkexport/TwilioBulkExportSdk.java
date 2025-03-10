package com.mycompany.myapp.twilo.api.bulkexport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.twilo.api.config.TwilioConfig;
import com.mycompany.myapp.twilo.api.config.TwilioConfigLoader;
import org.apache.http.HttpMessage;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TwilioBulkExportSdk {
    private static final String configFileName = "application-localkevin.properties";
    private static final TwilioConfig twilioConfig = TwilioConfigLoader.loadConfig(configFileName);

    private static final String BASE_URL = "https://bulkexports.twilio.com/v1/Exports";

    public static ExportJobResponseTwDto createExportJob(String resourceType, String startDay, String endDay, String friendlyName) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BASE_URL + "/" + resourceType + "/Jobs");
        setHttpAuthorizationHeaders(httpPost);

        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        String body = String.format(
                "StartDay=%s&EndDay=%s&FriendlyName=%s",
                startDay, endDay, friendlyName
        );
        httpPost.setEntity(new StringEntity(body));

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, ExportJobResponseTwDto.class);
        }
    }

    private static void setHttpAuthorizationHeaders(HttpMessage httpMessage) {
        httpMessage.setHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString(
                (twilioConfig.getApiKey() + ":" + twilioConfig.getApiSecret()).getBytes()));
        httpMessage.setHeader("Content-Type", "application/x-www-form-urlencoded");
    }

    public static ExportJobResponseTwDto createExportJob(ExportJobRequestTwDto request) throws IOException {
        ExportJobResponseTwDto response = createExportJob(
                request.getResourceType().toString(), request.getStartDate(), request.getEndDate(),
                "JobTest_" + request.getStartDate() + "_" + request.getEndDate()
        );
        System.out.println("Export Job: " + response.toString());
        return response;
    }

    public static ExportJobStatusTwDto getExportJobStatus(ExportResourceTypeTwDto resourceType, String jobSid) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/" + resourceType + "/Jobs/" + jobSid);
        setHttpAuthorizationHeaders(httpGet);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, ExportJobStatusTwDto.class);
        }
    }
}