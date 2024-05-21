package com.mikkytrionze.employeedirectory.contract.httpresponse;

public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    /// constructors
    
    public ErrorResponse() {}

    public ErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    /// setters and getters
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    
    /// tostring

    @Override
    public String toString() {
        return "ErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
    }
}
