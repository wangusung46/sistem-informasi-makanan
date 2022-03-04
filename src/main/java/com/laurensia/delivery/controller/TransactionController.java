package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.response.TransactionDetailResponse;
import com.laurensia.delivery.transaction.response.TransactionSaveResponse;
import com.laurensia.delivery.transaction.service.TransactionService;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class TransactionController {
    
    private final TransactionService transactionService;

    @PostMapping(value = "/transactions/user/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doSaveTransaction(@RequestBody TransactionSaveRequest request) throws JsonProcessingException {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        response = transactionService.saveTransaction(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/transactions/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doGetTransactionCustomer() throws JsonProcessingException {
        BaseResponse<List<TransactionDetailResponse>> responses = new BaseResponse<>();
        responses = transactionService.getTransactionByUserAndStatus(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping(value = "/transactions/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doGetTransactionAdmin() throws JsonProcessingException {
        BaseResponse<List<TransactionDetailResponse>> responses = new BaseResponse<>();
        responses = transactionService.getTransactionByUser();
        return ResponseEntity.ok(responses);
    }
    
}
