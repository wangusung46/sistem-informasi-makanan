package com.laurensia.delivery.transaction.service;

import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.transaction.model.Transaction;
import com.laurensia.delivery.transaction.repository.TransactionRepository;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.response.TransactionSaveResponse;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public BaseResponse<TransactionSaveResponse> saveTransaction(TransactionSaveRequest request) {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        TransactionSaveResponse detailResponse = new TransactionSaveResponse();
        Transaction transaction = new Transaction();
        transaction.setCountItem(request.getCountItem());
        transaction.setIdItem(request.getIdItem());
        transaction.setIdUser(request.getIdUser());
        transaction.setStatus(request.getStatus());
        transaction.setStatus(request.getStatus());
        transactionRepository.save(transaction);

        detailResponse.setCountItem(request.getCountItem());
        detailResponse.setIdItem(request.getIdItem());
        detailResponse.setIdUser(request.getIdUser());
        detailResponse.setStatus(request.getStatus());
        
        response.setStatus(true);
        response.setPayload(detailResponse);
        return response;
    }
    
}
