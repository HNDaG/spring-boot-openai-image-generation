package com.nikitahohulia.imgGenerator.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
public class RequestBodyPOJO {
    private String prompt;
    @Value("${api.request.body.n}")
    private int n;
    @Value("${api.request.body.size}")
    private String size;

    @Override
    public String toString() {
        return "{\r\n" +
                "    \"prompt\": \"" + prompt + "\",\r\n" +
                "    \"n\": 2,\r\n" +
                "    \"size\": \"1024x1024\"\r\n" +
                "}";
    }
}
