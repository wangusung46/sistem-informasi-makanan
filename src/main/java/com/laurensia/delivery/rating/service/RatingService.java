package com.laurensia.delivery.rating.service;

import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.rating.request.RatingSaveRequest;
import com.laurensia.delivery.rating.response.RatingSaveResponse;

/**
 * @author Khanza
 *
 */
public interface RatingService {
    
    public BaseResponse<RatingSaveResponse> saveRating(RatingSaveRequest request);

}
