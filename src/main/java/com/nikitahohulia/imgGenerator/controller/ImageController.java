package com.nikitahohulia.imgGenerator.controller;

import com.nikitahohulia.imgGenerator.builder.RequestBuilder;
import com.nikitahohulia.imgGenerator.models.ResponseBodyPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ImageController {
    @Value("${api.endpoint}")
    private String endpoint;

    @Autowired
    RequestBuilder requestBuilder;

    @GetMapping("/")
    String geHome(Model theModel) {
        return "home";
    }
    @PostMapping("/")
    String getImages(Model theModel, @RequestParam("myString") String prompt) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = requestBuilder.getRequest(prompt);


        ResponseEntity<ResponseBodyPOJO> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                entity,
                ResponseBodyPOJO.class
        );

        ResponseBodyPOJO responseBody = response.getBody();
        System.out.println(responseBody);
        theModel.addAttribute("images",responseBody.getData());
        return "images";
    }
}
