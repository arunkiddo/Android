package com.example.arun.chatbotfinal.Models;

/**
 * Created by lokesh on 9/15/2017.
 */

public class ChatModel {
    public String message;
    public boolean isSend;

    public ChatModel(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public ChatModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
