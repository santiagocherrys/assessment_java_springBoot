package com.riwi.assessment.infrastructure.abstract_services.generic;

public interface Update<Request, Response, ID>{
    Response update(Request request, ID id);
}
