package com.opsly.demo.models;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {

    private List<String> twitter = new ArrayList<>();
    private List<String> facebook = new ArrayList<>();
    private List<String> instagram = new ArrayList<>();

    public List<String> getTwitter() {
        return twitter;
    }

    public void setTwitter(List<String> twitter) {
        this.twitter = twitter;
    }

    public List<String> getFacebook() {
        return facebook;
    }

    public void setFacebook(List<String> facebook) {
        this.facebook = facebook;
    }

    public List<String> getInstagram() {
        return instagram;
    }

    public void setInstagram(List<String> instagram) {
        this.instagram = instagram;
    }
}
