package com.opsly.demo.dao;

import com.opsly.demo.models.FacebookResponse;
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
public class FacebookDao {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${app.social.urls.facebook}")
    private String url;

    public List<String> getStatuses() {
        try {
            ResponseEntity<FacebookResponse[]> twresponse = restTemplate.getForEntity(url, FacebookResponse[].class);
            FacebookResponse[] response = twresponse.getBody();
            return Arrays.stream(response).map(t -> t.getStatus()).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
