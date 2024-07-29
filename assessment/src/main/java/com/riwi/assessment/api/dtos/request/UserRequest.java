package com.riwi.assessment.api.dtos.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "name is required")
    @Size(min = 1, max = 50, message = "name exceeds the number of characters allowed(50)")
    private String name;
    @NotBlank(message = "last name is required")
    private String lastName;
}
