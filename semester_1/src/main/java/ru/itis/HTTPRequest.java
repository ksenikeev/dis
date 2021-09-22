package ru.itis;

import java.util.Map;

public class HTTPRequest {

    private Session session;

    private Map<String,String> params;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
