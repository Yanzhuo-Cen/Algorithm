package com.algorithm.entity;

public class User {

    private Integer id;

    private String name;

    private String password;

    private String states;

    private String date;

    public Integer getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getstates() {
        return states;
    }

    public void setstates(String states) {
        this.states = states;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String toString() {
        return "{" +
                id +
                name +
                password +
                states +
                date
                + '}';
    }
}
