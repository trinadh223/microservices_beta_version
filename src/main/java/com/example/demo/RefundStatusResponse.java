package com.example.demo;

public class RefundStatusResponse {
    String MID;
    String TXNID;
    String ORDERID;
    String BANKTXNID;
    String TXNAMOUNT;
    String STATUS;
    String RESPCODE;
    String RESPMSG;
    String TXNDATE;
    String GATEWAYNAME;
    String BANKNAME;
    String PAYMENTMODE;
    String TXNTYPE;
    String REFUNDAMT;

    public RefundStatusResponse(String MID, String TXNID, String ORDERID, String BANKTXNID, String TXNAMOUNT, String STATUS, String RESPCODE, String RESPMSG, String TXNDATE, String GATEWAYNAME, String BANKNAME, String PAYMENTMODE, String TXNTYPE, String REFUNDAMT) {
        this.MID = MID;
        this.TXNID = TXNID;
        this.ORDERID = ORDERID;
        this.BANKTXNID = BANKTXNID;
        this.TXNAMOUNT = TXNAMOUNT;
        this.STATUS = STATUS;
        this.RESPCODE = RESPCODE;
        this.RESPMSG = RESPMSG;
        this.TXNDATE = TXNDATE;
        this.GATEWAYNAME = GATEWAYNAME;
        this.BANKNAME = BANKNAME;
        this.PAYMENTMODE = PAYMENTMODE;
        this.TXNTYPE = TXNTYPE;
        this.REFUNDAMT = REFUNDAMT;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getTXNID() {
        return TXNID;
    }

    public void setTXNID(String TXNID) {
        this.TXNID = TXNID;
    }

    public String getORDERID() {
        return ORDERID;
    }

    public void setORDERID(String ORDERID) {
        this.ORDERID = ORDERID;
    }

    public String getBANKTXNID() {
        return BANKTXNID;
    }

    public void setBANKTXNID(String BANKTXNID) {
        this.BANKTXNID = BANKTXNID;
    }

    public String getTXNAMOUNT() {
        return TXNAMOUNT;
    }

    public void setTXNAMOUNT(String TXNAMOUNT) {
        this.TXNAMOUNT = TXNAMOUNT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getRESPCODE() {
        return RESPCODE;
    }

    public void setRESPCODE(String RESPCODE) {
        this.RESPCODE = RESPCODE;
    }

    public String getRESPMSG() {
        return RESPMSG;
    }

    public void setRESPMSG(String RESPMSG) {
        this.RESPMSG = RESPMSG;
    }

    public String getTXNDATE() {
        return TXNDATE;
    }

    public void setTXNDATE(String TXNDATE) {
        this.TXNDATE = TXNDATE;
    }

    public String getGATEWAYNAME() {
        return GATEWAYNAME;
    }

    public void setGATEWAYNAME(String GATEWAYNAME) {
        this.GATEWAYNAME = GATEWAYNAME;
    }

    public String getBANKNAME() {
        return BANKNAME;
    }

    public void setBANKNAME(String BANKNAME) {
        this.BANKNAME = BANKNAME;
    }

    public String getPAYMENTMODE() {
        return PAYMENTMODE;
    }

    public void setPAYMENTMODE(String PAYMENTMODE) {
        this.PAYMENTMODE = PAYMENTMODE;
    }

    public String getTXNTYPE() {
        return TXNTYPE;
    }

    public void setTXNTYPE(String TXNTYPE) {
        this.TXNTYPE = TXNTYPE;
    }

    public String getREFUNDAMT() {
        return REFUNDAMT;
    }

    public void setREFUNDAMT(String REFUNDAMT) {
        this.REFUNDAMT = REFUNDAMT;
    }
}