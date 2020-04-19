package com.piyu.uidashboard.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Application {
    @SerializedName("results")
    @Expose
    Results results;


    // Getter Methods

    public Results getResults() {
        return results;
    }

    // Setter Methods

    public void setResults( Results resultsObject ) {
        this.results=resultsObject;
    }
}