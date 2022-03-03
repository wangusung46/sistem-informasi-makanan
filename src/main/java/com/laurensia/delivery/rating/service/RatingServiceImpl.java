package com.laurensia.delivery.rating.service;

import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.rating.model.Rating;
import com.laurensia.delivery.rating.repository.RatingRepository;
import com.laurensia.delivery.rating.request.RatingSaveRequest;
import com.laurensia.delivery.rating.response.RatingSaveResponse;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public BaseResponse<RatingSaveResponse> saveRating(RatingSaveRequest request) {
        BaseResponse<RatingSaveResponse> response = new BaseResponse<>();
        RatingSaveResponse detailResponse = new RatingSaveResponse();
        Rating rating = new Rating();
        rating.setIdTransaction(request.getId_transaction());
        rating.setRate(request.getRate());
        rating.setReview(request.getReview());
        ratingRepository.save(rating);

        detailResponse.setIdTransaction(request.getId_transaction());
        detailResponse.setRate(request.getRate());
        detailResponse.setReview(request.getReview());
        
        response.setStatus(true);
        response.setPayload(detailResponse);
        return response;
    }

    
}
