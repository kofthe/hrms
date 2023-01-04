package com.mehmetari.hrms.core.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryUser(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dk141mwje",
                "api_key", "992622136187696",
                "api_secret", "IF4QZsLTzHotYrdrG0mIIOKVUJo",
                "secure", true));
        return cloudinary;
    }

}
