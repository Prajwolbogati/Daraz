package com.example.daraz.ServerResponse;

public class Imageresponse {
    private String Filename;

    public Imageresponse(String filename) {
        Filename = filename;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }
}
