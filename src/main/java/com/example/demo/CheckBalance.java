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

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }
    TransactionStatusResponse txnstatres;
    ValidateTokenResponse valt;
    final String userToken = "Delvit07224170213556";
    final String totalAmount = "REFUND";
    final String mid = "ORDER_123456789";
    final String txnId = txnstatres.getTXNID();
    final String refId = valt.getMobile();
    final String refundAmount = "1.00";
    final String MERCHANT_KEY = "&!vj74@Ri&g6U1TI";








}
