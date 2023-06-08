package com.nikitahohulia.imgGenerator.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResponseBodyPOJO {
    private long created;
    private List<Url> data;
}
