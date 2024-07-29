package com.riwi.assessment.infrastructure.abstract_services;

import com.riwi.assessment.api.dtos.request.UserReq;
import com.riwi.assessment.api.dtos.response.UserResp;
import com.riwi.assessment.infrastructure.abstract_services.generic.Create;
import com.riwi.assessment.infrastructure.abstract_services.generic.Delete;
import com.riwi.assessment.infrastructure.abstract_services.generic.GetAll;
import com.riwi.assessment.infrastructure.abstract_services.generic.Update;

public interface IUserClass extends
Create<UserReq, UserResp>,
Update<UserReq, UserResp, Long>,
Delete<Long>,
GetAll<UserResp>
{
    
}
