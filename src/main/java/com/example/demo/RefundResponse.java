package com.example.demo;

public class RefundResponse {
    Head head;
    Body body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public RefundResponse(Head head, Body body) {
        this.head = head;
        this.body = body;
    }

    public class Head{
        String clientId;
        String responseTimestamp;
        String signature;
        String version;

        public Head(String clientId, String responseTimestamp, String signature, String version) {
            this.clientId = clientId;
            this.responseTimestamp = responseTimestamp;
            this.signature = signature;
            this.version = version;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getResponseTimestamp() {
            return responseTimestamp;
        }

        public void setResponseTimestamp(String responseTimestamp) {
            this.responseTimestamp = responseTimestamp;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public class Body {
        Resultinfo resultinfo;

        public class Resultinfo {
            String resultStatus;
            String resultCode;
            String resultMsg;

            public Resultinfo(String resultStatus, String resultCode, String resultMsg) {
                this.resultStatus = resultStatus;
                this.resultCode = resultCode;
                this.resultMsg = resultMsg;
            }

            public String getResultStatus() {
                return resultStatus;
            }

            public void setResultStatus(String resultStatus) {
                this.resultStatus = resultStatus;
            }

            public String getResultCode() {
                return resultCode;
            }

            public void setResultCode(String resultCode) {
                this.resultCode = resultCode;
            }

            public String getResultMsg() {
                return resultMsg;
            }

            public void setResultMsg(String resultMsg) {
                this.resultMsg = resultMsg;
            }
        }

        String txnTimestamp;
        String orderId;
        String mid;
        String refId;
        String refundId;
        String txnId;
        String refundAmount;

        public Body(Resultinfo resultinfo, String txnTimestamp, String orderId, String mid, String refId, String refundId, String txnId, String refundAmount) {
            this.resultinfo = resultinfo;
            this.txnTimestamp = txnTimestamp;
            this.orderId = orderId;
            this.mid = mid;
            this.refId = refId;
            this.refundId = refundId;
            this.txnId = txnId;
            this.refundAmount = refundAmount;
        }

        public Resultinfo getResultinfo() {
            return resultinfo;
        }

        public void setResultinfo(Resultinfo resultinfo) {
            this.resultinfo = resultinfo;
        }

        public String getTxnTimestamp() {
            return txnTimestamp;
        }

        public void setTxnTimestamp(String txnTimestamp) {
            this.txnTimestamp = txnTimestamp;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getRefId() {
            return refId;
        }

        public void setRefId(String refId) {
            this.refId = refId;
        }

        public String getRefundId() {
            return refundId;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public String getTxnId() {
            return txnId;
        }

        public void setTxnId(String txnId) {
            this.txnId = txnId;
        }

        public String getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(String refundAmount) {
            this.refundAmount = refundAmount;
        }
    }
    }
