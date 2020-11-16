package com.opsly.demo.dao;

import com.opsly.demo.models.TwitterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TwitterDao {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${app.social.urls.twitter}")
    private String url;

    public List<String> getTweets() {
        try {
            ResponseEntity<TwitterResponse[]> twresponse = restTemplate.getForEntity(url, TwitterResponse[].class);
            TwitterResponse[] response = twresponse.getBody();
            return Arrays.stream(response).map(t -> t.getTweet()).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
