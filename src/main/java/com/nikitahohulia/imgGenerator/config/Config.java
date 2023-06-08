package com.nikitahohulia.imgGenerator.config;

import com.nikitahohulia.imgGenerator.models.RequestBodyPOJO;
import com.nikitahohulia.imgGenerator.models.ResponseBodyPOJO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public RequestBodyPOJO newRequestBody(){
        return new RequestBodyPOJO();
    }

    @Bean
    public ResponseBodyPOJO newResponseBody(){
        return new ResponseBodyPOJO();
    }

}
