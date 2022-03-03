package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.item.service.ItemService;
import com.laurensia.delivery.user.request.UserIdRequest;
import com.laurensia.delivery.user.request.UserSaveRequest;
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

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doListUser() throws JsonProcessingException {
        BaseResponse<List<UserDetailResponse>> responses = new BaseResponse<>();
        responses = userService.getUsers();
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doUser(@PathVariable("id") Long request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.getUser(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/users/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doSaveUser(@RequestBody UserSaveRequest request) throws JsonProcessingException {
        BaseResponse<UserSaveResponse> response = new BaseResponse<>();
        response = userService.saveUser(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/users/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doDeleteUser(@RequestBody UserIdRequest request) throws JsonProcessingException {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        response = userService.deleteUser(request);
        return ResponseEntity.ok(response);
    }
    
}
