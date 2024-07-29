package com.riwi.assessment.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface GetAll<Response> {
    Page<Response> getAll(int page, int size);
}
