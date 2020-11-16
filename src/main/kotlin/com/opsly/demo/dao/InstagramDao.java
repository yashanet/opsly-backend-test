package com.opsly.demo.dao;

import com.opsly.demo.models.InstagramResponse;
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
public class InstagramDao {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${app.social.urls.instagram}")
    private String url;

    public List<String> getPhotos() {
        try {
            ResponseEntity<InstagramResponse[]> twresponse = restTemplate.getForEntity(url, InstagramResponse[].class);
            InstagramResponse[] response = twresponse.getBody();
            return Arrays.stream(response).map(t -> t.getPhoto()).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
