package com.mycompany.myapp.twilo.api.bulkexport.download;

import com.mycompany.myapp.twilo.api.bulkexport.TwilioSdkHelper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Deprecated
public class TwilioJobDownloadSdkV1 {

    private static final String BASE_URL = "https://bulkexports.twilio.com/v1/Exports/Messages/Jobs";

    public static String downloadMessages(String jobSid) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(BASE_URL + "/" + jobSid + "/Media");
        TwilioSdkHelper.setHttpAuthorizationHeaders(httpGet);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            return jsonResponse;
        }
    }
}