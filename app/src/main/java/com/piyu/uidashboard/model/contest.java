package com.piyu.uidashboard.model;

public class contest {
    String name;
    String url;
    String platform;
    String starttime;
    String  endtime;

    public contest() {
    }

    public contest(String name, String url, String platform, String starttime, String endtime) {
        this.name = name;
        this.url = url;
        this.platform = platform;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
