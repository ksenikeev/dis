package ru.itis;

public interface RequestHandler {
    void process(HTTPRequest request, HTTPResponse response);
}
