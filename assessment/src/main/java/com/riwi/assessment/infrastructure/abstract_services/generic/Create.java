package com.riwi.assessment.infrastructure.abstract_services.generic;

public interface Create<Request ,Response> {
    Response create(Request request);
}
