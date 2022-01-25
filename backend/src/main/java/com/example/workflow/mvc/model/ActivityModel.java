package com.example.workflow.mvc.model;

public class ActivityModel {
    
    private String activity;
    private String type;
    private long participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String value) {
        this.activity = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public long getParticipants() {
        return participants;
    }

    public void setParticipants(long value) {
        this.participants = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double value) {
        this.price = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String value) {
        this.link = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String value) {
        this.key = value;
    }

    public double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(double value) {
        this.accessibility = value;
    }
}
