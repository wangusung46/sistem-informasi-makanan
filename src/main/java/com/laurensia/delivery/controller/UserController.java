package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.user.request.UserIdRequest;
import com.laurensia.delivery.user.request.UserRegistrationRequest;
import com.laurensia.delivery.user.request.UserSaveRequest;
import com.laurensia.delivery.user.request.UserUpdateRequest;
import com.laurensia.delivery.user.response.UserDetailResponse;
import com.laurensia.delivery.user.response.UserSaveResponse;
import com.laurensia.delivery.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/customer/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doCustomerUser() throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.getUser();
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/customer/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doCustomerUserRegister(@RequestBody UserRegistrationRequest request) throws JsonProcessingException {
        BaseResponse<UserSaveResponse> response = new BaseResponse<>();
        response = userService.saveUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminListUser() throws JsonProcessingException {
        BaseResponse<List<UserDetailResponse>> responses = new BaseResponse<>();
        responses = userService.getUsers();
        return ResponseEntity.ok(responses);
    }
    
    @PostMapping(value = "/admin/users/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminUpdateUser(@RequestBody UserUpdateRequest request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.updateUser(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/staff/users/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doStaffUpdateUser(@RequestBody UserUpdateRequest request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.updateUser(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/customer/users/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doCustomerUpdateUser(@RequestBody UserUpdateRequest request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.updateUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/admin/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminUser(@PathVariable("id") Long request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.getUser();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/admin/users/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminSaveUser(@RequestBody UserSaveRequest request) throws JsonProcessingException {
        BaseResponse<UserSaveResponse> response = new BaseResponse<>();
        response = userService.saveUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/admin/users/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminDeleteUser(@RequestBody UserIdRequest request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.deleteUser(request);
        return ResponseEntity.ok(response);
    }

}
