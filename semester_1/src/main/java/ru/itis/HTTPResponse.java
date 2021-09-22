package ru.itis;

import java.io.OutputStream;

public class HTTPResponse {

    private int responseCode = 200;
    private OutputStream outputStream;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
