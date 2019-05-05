package com.qhit.reports.pojo;

public class JobBin {
    private String fname;
    private String tname;
    private String  dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "JobBin{" +
                "fname='" + fname + '\'' +
                ", tname='" + tname + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}
