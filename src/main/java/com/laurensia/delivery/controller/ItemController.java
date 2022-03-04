package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.item.service.ItemService;
import com.laurensia.delivery.item.request.ItemIdRequest;
import com.laurensia.delivery.item.request.ItemSaveRequest;
import com.laurensia.delivery.item.response.ItemDetailResponse;
import com.laurensia.delivery.item.response.ItemSaveResponse;
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
public class ItemController {
    
    private final ItemService itemService;

    
    @GetMapping(value = "/customer/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doCustomerListItem() throws JsonProcessingException {
        BaseResponse<List<ItemDetailResponse>> responses = new BaseResponse<>();
        responses = itemService.getItems();
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping(value = "/customer/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doCustomerItem(@PathVariable("id") Long request) throws JsonProcessingException {
        BaseResponse<ItemDetailResponse> response = new BaseResponse<>();
        response = itemService.getItem(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/admin/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminListItem() throws JsonProcessingException {
        BaseResponse<List<ItemDetailResponse>> responses = new BaseResponse<>();
        responses = itemService.getItems();
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping(value = "/admin/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminItem(@PathVariable("id") Long request) throws JsonProcessingException {
        BaseResponse<ItemDetailResponse> response = new BaseResponse<>();
        response = itemService.getItem(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/admin/items/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminSaveItem(@RequestBody ItemSaveRequest request) throws JsonProcessingException {
        BaseResponse<ItemSaveResponse> response = new BaseResponse<>();
        response = itemService.saveItem(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping(value = "/admin/items/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminDeleteItem(@RequestBody ItemIdRequest request) throws JsonProcessingException {
        BaseResponse<ItemDetailResponse> response = new BaseResponse<>();
        response = itemService.deleteItem(request);
        return ResponseEntity.ok(response);
    }
}
