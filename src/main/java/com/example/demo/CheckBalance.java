package com.example.demo;

import com.paytm.pg.merchant.CheckSumServiceHelper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TreeMap;

public class CheckBalance {
    String responseData;

    public String getResponseData() {
        return responseData;
    }

    HttpURLConnection connection = null;

    String mid = "Delvit07224170213556";
     String orderId = "ORDER_123456789";
     String ssoToken = "31add395-f16b-4dc0-b066-9139b5821700";
     String amount = "100";
     String MERCHANT_KEY = "&!vj74@Ri&g6U1TI";
     Long time=System.currentTimeMillis();
    public void check_balance(String args[]){
        try {

            String bodyTemp = "{\"userToken\": \"" + ssoToken + "\",\"totalAmount\": \"" + amount + "\","
                    + "\"mid\": \"" + mid + "\"}";

            String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, bodyTemp);

            String body = "{\"head\":{\"clientId\":\"merchant-perpule-stg\",\"version\":\"v1\",\"requestTimestamp\":\"Time\","
                    + "\"channelId\":\"WEB\",\"signature\":\"" + checksum + "\"},\"body\":" + bodyTemp + "}";

            URL url = new URL("https://securegw-stage.paytm.in/paymentservices/pay/consult");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(body);
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
            if ((responseData = responseReader.readLine()) != null) {
                System.out.append("Response: " + responseData);
            }
            // System.out.append("Request: " + post_data + " ");
            responseReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }




    }
}
