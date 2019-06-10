package com.piyu.uidashboard;

public class jsonResponse {
private  String codename;
private String name;
private  String startdate;
private  String enddate;

    public jsonResponse(String codename, String name, String startdate, String enddate) {
        this.codename = codename;
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "jsonResponse{" +
                "codename='" + codename + '\'' +
                ", name='" + name + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                '}';
    }
}
