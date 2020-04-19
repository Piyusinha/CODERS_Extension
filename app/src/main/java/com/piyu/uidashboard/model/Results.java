package com.piyu.uidashboard.model;

import java.util.ArrayList;

public class Results {
    private float timestamp;
    ArrayList<contest> ongoing = new ArrayList<contest>();
    ArrayList<contest> upcoming = new ArrayList<contest>();

    public ArrayList<contest> getOngoing() {
        return ongoing;
    }

    public void setOngoing(ArrayList<contest> ongoing) {
        this.ongoing = ongoing;
    }

    public ArrayList<contest> getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(ArrayList<contest> upcoming) {
        this.upcoming = upcoming;
    }




    // Getter Methods

    public float getTimestamp() {
        return timestamp;
    }

    // Setter Methods

    public void setTimestamp( float timestamp ) {
        this.timestamp = timestamp;
    }
}