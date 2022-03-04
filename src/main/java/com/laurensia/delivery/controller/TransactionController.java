package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.transaction.request.TransactionIdRequest;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.response.TransactionDetailResponse;
import com.laurensia.delivery.transaction.response.TransactionSaveResponse;
import com.laurensia.delivery.transaction.service.TransactionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.laurensia.delivery.transaction.response.TransactionDetailTotalResponse;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    
    private final TransactionService transactionService;

    @PostMapping(value = "/customer/transactions/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doSaveTransaction(@RequestBody TransactionSaveRequest request) throws JsonProcessingException {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        response = transactionService.saveTransaction(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping(value = "/customer/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doCustomerGetTransactionCustomer() throws JsonProcessingException {
        BaseResponse<List<TransactionDetailResponse>> responses = new BaseResponse<>();
        responses = transactionService.getTransactionByUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(responses);
    }
    
//    @GetMapping(value = "/admin/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<BaseResponse<?>> doAdminGetTransaction() throws JsonProcessingException {
//        BaseResponse<List<TransactionDetailResponse>> responses = new BaseResponse<>();
//        responses = transactionService.getTransactionByUser();
//        return ResponseEntity.ok(responses);
//    }
    
    @GetMapping(value = "/admin/transactions/total-rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doAdminGetTransactionTotalRating() throws JsonProcessingException {
        BaseResponse<List<TransactionDetailTotalResponse>> responses = new BaseResponse<>();
        responses = transactionService.getTransactionByUserTotalRating();
        return ResponseEntity.ok(responses);
    }
    
    @GetMapping(value = "/staff/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doStaffGetTransaction() throws JsonProcessingException {
        BaseResponse<List<TransactionDetailResponse>> responses = new BaseResponse<>();
        responses = transactionService.getTransactionByStaff(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok(responses);
    }
    
    @PostMapping(value = "/staff/transactions/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doStaffUpdateTransaction(@RequestBody TransactionIdRequest request) throws JsonProcessingException {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        response = transactionService.updateTransactionByStaff(request.getId());
        return ResponseEntity.ok(response);
    }
    
}
