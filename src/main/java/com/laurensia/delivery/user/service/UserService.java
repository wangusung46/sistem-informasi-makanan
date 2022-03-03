package com.laurensia.delivery.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.user.request.UserIdRequest;
import com.laurensia.delivery.user.request.UserSaveRequest;
import com.laurensia.delivery.user.response.UserDetailResponse;
import com.laurensia.delivery.user.response.UserSaveResponse;
import java.util.List;

/**
 * @author Khanza
 *
 */
public interface UserService {

    public BaseResponse<List<UserDetailResponse>> getUsers() throws JsonProcessingException;

    public BaseResponse<UserSaveResponse> saveUser(UserSaveRequest request);

    public BaseResponse<UserDetailResponse> deleteUser(UserIdRequest request);

    public BaseResponse<UserDetailResponse> getUser(Long request);
    
    public String getName(String email);

}
