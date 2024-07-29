package com.riwi.assessment.infrastructure.abstract_services;

public interface GetById<Response, ID>{
    Response getById(ID id);
}
