package ru.itis;

import java.util.HashMap;
import java.util.Map;

public class Context {

    //resource handlers
    private Map<String, RequestHandler> handlerMap = new HashMap<>();

    //cookies
    private Map<String, Session> sessionMap = new HashMap<>();


    public Map<String, RequestHandler> getHandlerMap() {
        return handlerMap;
    }

    public void setHandlerMap(Map<String, RequestHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public Map<String, Session> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Session> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
