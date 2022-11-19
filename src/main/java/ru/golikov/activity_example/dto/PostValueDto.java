package ru.golikov.activity_example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostValueDto {

    @JsonProperty("post_value")
    private Integer postValue;
}
