package com.riwi.assessment.api.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {
    @NotBlank(message = "The id can't be null")
    private Long id;
    @NotBlank(message = "The user name can't be null")
    private String userName;
    @NotBlank(message = "The name can't be null")
    private String name;
    @Email(message = "The email must be valid")
    @NotBlank(message = "The email can't be null")
    @Size(max = 25, min = 10, message = "The email can't be larger than 25 characters or less than 10 characters")
    private String email;
    @NotBlank(message = "The password can't be null")
    private String password;
}
