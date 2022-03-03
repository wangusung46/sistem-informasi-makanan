package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.response.TransactionSaveResponse;
import com.laurensia.delivery.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class TransactionController {
    
    private final TransactionService transactionService;

    @PostMapping(value = "/transactions/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doSaveTransaction(@RequestBody TransactionSaveRequest request) throws JsonProcessingException {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        response = transactionService.saveTransaction(request);
        return ResponseEntity.ok(response);
    }
    
}
