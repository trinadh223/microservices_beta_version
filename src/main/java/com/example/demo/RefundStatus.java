package com.example.demo;

import com.paytm.pg.merchant.CheckSumServiceHelper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TreeMap;

public class RefundStatus {

    final String MERCHANT_MID = "Delvit07224170213556";
    final String MERCHANT_KEY = "&!vj74@Ri&g6U1TI";
    String orderId;

    public RefundStatus(String orderId, String refId, String responseData) {
        this.orderId = orderId;
        this.refId = refId;
        this.responseData = responseData;
    }

    String refId;
    String responseData;


    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public void Refund_status_api() {

        TreeMap<String, String> paytmParams = new TreeMap<String, String>();
        paytmParams.put("mid", MERCHANT_MID);
        paytmParams.put("orderId", orderId);
        paytmParams.put("refId", refId);


        try {
            URL url = new URL("https://securegw-stage.paytm.in/refund/api/v1/refundStatus");

            String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, paytmParams);
            String paytmParams_head = "{\"clientId\":\"C11\",\"version\":\"v1\",\"signature\":\"" + checksum + "\"}";
            String paytmParams_body = "{\"mid\":\"" + MERCHANT_MID + "\",\"orderId\":\"" + orderId + "\",\"refId\":\"" + refId + "\"}";
            String post_data = "{\"body\":" + paytmParams_body + ",\"head\":" + paytmParams_head + "}";


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
            requestWriter.writeBytes(post_data);
            requestWriter.close();
            String responseData = "";
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