package com.algorithm.entity;

public class Photo {

    private Integer id;

    private String name;

    private String fileName;

    private String filePath;

    public Integer getid() {
        return id;
    }

    public void setid(Integer ID) {
        this.id = ID;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getfileName() {
        return fileName;
    }

    public void setfileName(String fileName) {
        this.fileName = fileName;
    }

    public String getfilePath() {
        return filePath;
    }

    public void setfilePath(String filePath) {
        this.filePath = filePath;
    }


    public String toString() {
        return "{" +
                id +
                name +
                fileName +
                filePath
                + '}';
    }
}
