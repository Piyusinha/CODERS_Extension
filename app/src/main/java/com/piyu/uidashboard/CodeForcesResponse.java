package com.piyu.uidashboard;

import android.widget.TextView;

public class CodeForcesResponse {
    private String name;
    private String writers;
    private String start;
    private String  length;
    private  String beforestart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getBeforestart() {
        return beforestart;
    }

    public void setBeforestart(String beforestart) {
        this.beforestart = beforestart;
    }

    public CodeForcesResponse(String name, String writers, String start, String length, String beforestart) {
        this.name = name;
        this.writers = writers;
        this.start = start;
        this.length = length;
        this.beforestart = beforestart;
    }

    @Override
    public String toString() {
        return "CodeForcesResponse{" +
                "name='" + name + '\'' +
                ", writers='" + writers + '\'' +
                ", start='" + start + '\'' +
                ", length='" + length + '\'' +
                ", beforestart='" + beforestart + '\'' +
                '}';
    }
}
