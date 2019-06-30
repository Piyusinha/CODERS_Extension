package com.piyu.uidashboard;

public class hackerrankresponse {
    private String name;
    private String desc;
    private  String startdate;
    private  String enddate;
    private String urlslug;

    public String getUrlslug() {
        return urlslug;
    }

    public void setUrlslug(String urlslug) {
        this.urlslug = urlslug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public hackerrankresponse(String name, String desc, String startdate, String enddate, String urlslug) {
        this.name = name;
        this.desc = desc;
        this.startdate = startdate;
        this.enddate = enddate;
        this.urlslug = urlslug;
    }

    @Override
    public String toString() {
        return "hackerrankresponse{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", urlslug='" + urlslug + '\'' +
                '}';
    }
}
