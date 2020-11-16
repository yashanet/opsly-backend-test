package com.opsly.demo.service.impl;

import com.opsly.demo.dao.FacebookDao;
import com.opsly.demo.dao.InstagramDao;
import com.opsly.demo.dao.TwitterDao;
import com.opsly.demo.models.ResponseDTO;
import com.opsly.demo.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialServiceImpl implements SocialService {

    @Autowired
    private TwitterDao twitterDao;
    @Autowired
    private FacebookDao facebookDao;
    @Autowired
    private InstagramDao instagramDao;

    @Override
    public ResponseDTO getNews() {
        ResponseDTO dto = new ResponseDTO();
        dto.getTwitter().addAll(twitterDao.getTweets());
        dto.getFacebook().addAll(facebookDao.getStatuses());
        dto.getInstagram().addAll(instagramDao.getPhotos());
        return dto;
    }

}
