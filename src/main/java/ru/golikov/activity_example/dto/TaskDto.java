package ru.golikov.activity_example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {

    private String id;

    @JsonProperty("is_completed")
    private boolean isCompleted;

    @JsonProperty("post_value")
    private Integer postValue;

    @JsonProperty("random_data")
    private Integer randomData;

    private Integer summa;

    @JsonProperty("task_property")
    private String taskProperty;
}
