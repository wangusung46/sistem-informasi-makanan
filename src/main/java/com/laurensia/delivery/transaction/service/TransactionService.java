package com.laurensia.delivery.transaction.service;

import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.response.TransactionSaveResponse;


/**
 * @author Khanza
 *
 */
public interface TransactionService {
    
    public BaseResponse<TransactionSaveResponse> saveTransaction(TransactionSaveRequest request);

}
