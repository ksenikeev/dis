package ru.itis.lab3;

import java.util.Date;

public class Message {

    private String dstClientName;
    private String srcClientName;
    private String messageText;
    private Date msgDate;

    public Message(String dstClientName, String srcClientName, String messageText, Date msgDate) {
        this.dstClientName = dstClientName;
        this.srcClientName = srcClientName;
        this.messageText = messageText;
        this.msgDate = msgDate;
    }

    public Message() {
    }

    //TODO - добавить выброс исключения, если формат сообщения неверный
    public Message writeMessage(String msg, String srcClientName) {

        String[] str = msg.split(";");

        this.dstClientName = str[0];
        this.messageText = str[1];
        this.srcClientName = srcClientName;
        this.msgDate = new Date();

        return this;
    }

    public String getDstClientName() {
        return dstClientName;
    }

    public void setDstClientName(String dstClientName) {
        this.dstClientName = dstClientName;
    }

    public String getSrcClientName() {
        return srcClientName;
    }

    public void setSrcClientName(String srcClientName) {
        this.srcClientName = srcClientName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }
}
