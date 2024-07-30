package com.riwi.assessment.api.dtos.errors;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError implements Serializable {
    private String status;
    private Integer code;
    private Map<String,String> error;
}
