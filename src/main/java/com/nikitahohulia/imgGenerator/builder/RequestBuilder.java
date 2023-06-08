package com.nikitahohulia.imgGenerator.builder;


import com.nikitahohulia.imgGenerator.models.RequestBodyPOJO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestBuilder {
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.host}")
    private String host;

    RequestBodyPOJO requestBodyPOJO;

    public RequestBuilder(RequestBodyPOJO requestBodyPOJO) {
        this.requestBodyPOJO = requestBodyPOJO;
    }

    public  HttpEntity<String> getRequest(String prompt) {
        requestBodyPOJO.setPrompt(prompt);
        String requestBody = requestBodyPOJO.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", host);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        return entity;
    }

}
