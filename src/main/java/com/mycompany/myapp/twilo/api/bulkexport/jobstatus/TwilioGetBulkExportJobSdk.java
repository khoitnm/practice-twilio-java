package com.mycompany.myapp.twilo.api.bulkexport.jobstatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.twilo.api.bulkexport.ExportResourceTypeTwDto;
import com.mycompany.myapp.twilo.api.bulkexport.TwilioSdkHelper;
import com.mycompany.myapp.twilo.api.bulkexport.createjob.ExportJobRequestTwDto;
import com.mycompany.myapp.twilo.api.bulkexport.createjob.ExportJobResponseTwDto;
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

public class TwilioGetBulkExportJobSdk {
    private static final String BASE_URL = "https://bulkexports.twilio.com/v1/Exports";

    public static ExportJobStatusTwDto getExportJobStatus(ExportResourceTypeTwDto resourceType, String jobSid) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/" + resourceType + "/Jobs/" + jobSid);
        TwilioSdkHelper.setHttpAuthorizationHeaders(httpGet);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, ExportJobStatusTwDto.class);
        }
    }
}