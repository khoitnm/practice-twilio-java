package com.mycompany.myapp.twilo.api.bulkexport.download;

import com.mycompany.myapp.twilo.api.bulkexport.TwilioSdkHelper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @deprecated Still doesn't work.
 */
@Deprecated
public class TwilioJobStatusSdkV2 {
    private static final String BASE_URL = "https://api.twilio.com/2010-04-01/Accounts/";

    public static String getJobData(String jobSid) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlString = BASE_URL + TwilioSdkHelper.twilioConfig.getAccountSid() + "/BulkExports/Jobs/" + jobSid + ".json";

        HttpGet httpGet = new HttpGet(urlString);
        TwilioSdkHelper.setHttpAuthorizationHeaders(httpGet);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println("\nJob Status: " + jsonResponse);
            return jsonResponse;
        }
    }
}
