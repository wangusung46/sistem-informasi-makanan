package com.laurensia.delivery.transaction.service;

import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.transaction.model.Transaction;
import com.laurensia.delivery.transaction.repository.TransactionRepository;
import com.laurensia.delivery.transaction.request.TransactionSaveRequest;
import com.laurensia.delivery.transaction.response.TransactionDetailResponse;
import com.laurensia.delivery.transaction.response.TransactionDetailTotalResponse;
import com.laurensia.delivery.transaction.response.TransactionSaveResponse;
import com.laurensia.delivery.user.model.User;
import com.laurensia.delivery.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    
    private final UserRepository userRepository;

    @Override
    public BaseResponse<TransactionSaveResponse> saveTransaction(TransactionSaveRequest request) {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        TransactionSaveResponse detailResponse = new TransactionSaveResponse();
        Transaction transaction = new Transaction();
        transaction.setCountItem(request.getCountItem());
        transaction.setIdItem(request.getIdItem());
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        transaction.setIdUser(user.getId());
        transaction.setStatus(request.getStatus());
        transaction.setStatus(request.getStatus());
        transactionRepository.save(transaction);

        detailResponse.setCountItem(request.getCountItem());
        detailResponse.setIdItem(request.getIdItem());
        detailResponse.setIdUser(user.getId());
        detailResponse.setStatus(request.getStatus());

        response.setStatus(true);
        response.setPayload(detailResponse);
        return response;
    }

    @Override
    public BaseResponse<List<TransactionDetailResponse>> getTransactionByUser(String request) {
        BaseResponse<List<TransactionDetailResponse>> response = new BaseResponse<>();
        List<TransactionDetailResponse> detailResponses = transactionRepository.findByUserTransaction(request);
        if (detailResponses != null) {
            response.setStatus(true);
            response.setPayload(detailResponses);
        } else {
            response.setStatus(false);
        }
        return response;
    }

//    @Override
//    public BaseResponse<List<TransactionDetailResponse>> getTransaction() {
//        BaseResponse<List<TransactionDetailResponse>> response = new BaseResponse<>();
//        List<TransactionDetailResponse> detailResponses = transactionRepository.findByAdminTransaction();
//        if (detailResponses != null) {
//            response.setStatus(true);
//            response.setPayload(detailResponses);
//        } else {
//            response.setStatus(false);
//        }
//        return response;
//    }
//    @Override
//    public BaseResponse<List<TransactionDetailResponse>> getTransactionByUser() {
//        BaseResponse<List<TransactionDetailResponse>> response = new BaseResponse<>();
//        List<TransactionDetailResponse> detailResponses = transactionRepository.findByUser();
//        if (detailResponses != null) {
//            response.setStatus(true);
//            response.setPayload(detailResponses);
//        } else {
//            response.setStatus(false);
//        }
//        return response;
//    }
    @Override
    public BaseResponse<List<TransactionDetailTotalResponse>> getTransactionByUserTotalRating() {
        BaseResponse<List<TransactionDetailTotalResponse>> response = new BaseResponse<>();
        List<TransactionDetailTotalResponse> detailResponses = transactionRepository.findByUserTotalRating();
        if (detailResponses != null) {
            response.setStatus(true);
            response.setPayload(detailResponses);
        } else {
            response.setStatus(false);
        }
        return response;
    }

    @Override
    public BaseResponse<List<TransactionDetailResponse>> getTransactionByStaff(String request) {
        BaseResponse<List<TransactionDetailResponse>> response = new BaseResponse<>();
        List<TransactionDetailResponse> detailResponses = transactionRepository.findByStaffTransaction(request);
        if (detailResponses != null) {
            response.setStatus(true);
            response.setPayload(detailResponses);
        } else {
            response.setStatus(false);
        }
        return response;
    }

    @Override
    public BaseResponse<TransactionSaveResponse> updateTransactionByStaff(Long request) {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        TransactionSaveResponse detailResponse = new TransactionSaveResponse();
//        Transaction transaction = new Transaction();
        Optional<Transaction> optional = transactionRepository.findById(request);
        if (optional.isPresent()) {
            if(optional.get().getStatus().equals("ORDER")){
                optional.get().setStatus("DELIVERY");
            } else if(optional.get().getStatus().equals("DELIVERY")){
                optional.get().setStatus("COMPLETE");
            }
            optional.get().setId(request);
            transactionRepository.save(optional.get());

            detailResponse.setCountItem(optional.get().getCountItem());
            detailResponse.setIdItem(optional.get().getIdItem());
            detailResponse.setIdUser(optional.get().getIdUser());
            detailResponse.setStatus(optional.get().getStatus());

            response.setStatus(true);
            response.setPayload(detailResponse);
        } else {
            response.setStatus(false);
        }

        return response;
    }

}
