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

    public CheckBalance() {
    }
    ValidateOtpResponse votp;
     String mid = "Delvit07224170213556";
     String orderId = "ORDER_123456789";
     String userToken = votp.getAccess_token();
     String totalAmount = "1.00";
     String MERCHANT_KEY = "&!vj74@Ri&g6U1TI";
    public void check_balance(){
        TreeMap<String, String> paytmParams = new TreeMap<String, String>();
        paytmParams.put("MID", mid);
        paytmParams.put("userToken", userToken);
        paytmParams.put("totalAmount", totalAmount);

        try {
            URL url = new URL("https://securegw-stage.paytm.in/paymentservices/pay/consult"); // for staging
            String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, paytmParams);
            String paytmParams_head = "{\"clientId\":\"merchant-perpule-stg\",\"version\":\"V1\",\"requestTimestamp\":\""+votp.getExpires()+"\",\"channelId\":\"WAP\",\"signature\":\""+checksum+"\"}";
            String paytmParams_body = "{\"userToken\":\"" + userToken + "\",\"totalAmount\":\""+totalAmount+"\",\"mid\":\""+mid+"\"}";
            String post_data = "{\"body\":" + paytmParams_body + ",\"head\":" + paytmParams_head + "}";



            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
            requestWriter.writeBytes(post_data);
            requestWriter.close();
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
