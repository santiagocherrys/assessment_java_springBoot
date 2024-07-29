package com.riwi.assessment.infrastructure.abstract_services;

public interface Create<Request ,Response> {
    Response create(Request request);
}
