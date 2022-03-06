package com.laurensia.delivery.transaction.service;

import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.rating.model.Rating;
import com.laurensia.delivery.rating.repository.RatingRepository;
import com.laurensia.delivery.transaction.model.Transaction;
import com.laurensia.delivery.transaction.repository.TransactionRepository;
import com.laurensia.delivery.transaction.request.TransactionSaveRatingRequest;
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

    private final RatingRepository ratingRepository;

    @Override
    public BaseResponse<TransactionSaveResponse> saveTransaction(TransactionSaveRequest request) {
        BaseResponse<TransactionSaveResponse> response = new BaseResponse<>();
        TransactionSaveResponse detailResponse = new TransactionSaveResponse();
        Transaction transaction = new Transaction();
        transaction.setCountItem(request.getCountItem());
        transaction.setIdItem(request.getIdItem());
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        transaction.setIdUser(user.getId());
        transaction.setStatus("ORDER");
        transactionRepository.save(transaction);

        detailResponse.setCountItem(request.getCountItem());
        detailResponse.setIdItem(request.getIdItem());
        detailResponse.setIdEmail(user.getEmail());
        detailResponse.setIdUser(user.getId());
        detailResponse.setStatus("ORDER");

        response.setStatus(true);
        response.setPayload(detailResponse);
        return response;
    }

    @Override
    public BaseResponse<List<TransactionDetailResponse>> getTransactionByUser(String request) {
        BaseResponse<List<TransactionDetailResponse>> response = new BaseResponse<>();
        List<TransactionDetailResponse> detailResponses = transactionRepository.findByUserTransactions(request);
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
        List<TransactionDetailTotalResponse> detailResponses = transactionRepository.findByUserTotalRatings();
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
        List<TransactionDetailResponse> detailResponses = transactionRepository.findByStaffTransactions(request);
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
        Optional<Transaction> optional = transactionRepository.findById(request);
        if (optional.isPresent()) {
            if (optional.get().getStatus().equals("ORDER")) {
                optional.get().setStatus("DELIVERY");
            } else if (optional.get().getStatus().equals("DELIVERY")) {
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

    @Override
    public BaseResponse<List<TransactionDetailResponse>> saveRatingTransaction(TransactionSaveRatingRequest request) {
        BaseResponse<List<TransactionDetailResponse>> response = new BaseResponse<>();

        Rating rating = new Rating();

        Rating rating1 = ratingRepository.findByIdTransaction(request.getIdTransaction());

        if (rating1 == null ) {
            if (request.getIdTransaction() != null) {
                if (request.getRate() == null) {
                    rating.setRate(0);
                } else {
                    rating.setRate(request.getRate());
                }
                if (request.getReview() == null) {
                    rating.setReview("Not Review");
                } else {
                    rating.setReview(request.getReview());
                }
                rating.setIdTransaction(request.getIdTransaction());
                ratingRepository.save(rating);
                List<TransactionDetailResponse> detailResponse = transactionRepository.findByUserTransaction(SecurityContextHolder.getContext().getAuthentication().getName(), request.getIdTransaction());
                response.setPayload(detailResponse);
                response.setStatus(true);
            } else {
                response.setStatus(false);
            }
        }

        return response;
    }

}
