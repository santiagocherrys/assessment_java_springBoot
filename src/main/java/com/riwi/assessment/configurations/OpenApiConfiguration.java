package com.riwi.assessment.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Assessment",
                version = "1.0",
                description = "EndPoint documentation of the assessment"
        )
)
public class OpenApiConfiguration {
}
