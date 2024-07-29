package com.riwi.assessment.infrastructure.abstract_services.generic;

public interface GetById<Response, ID>{
    Response getById(ID id);
}
