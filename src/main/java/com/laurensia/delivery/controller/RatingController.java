package com.laurensia.delivery.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.rating.request.RatingSaveRequest;
import com.laurensia.delivery.rating.response.RatingSaveResponse;
import com.laurensia.delivery.rating.service.RatingService;
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
public class RatingController {
    
    private final RatingService ratingService;

    @PostMapping(value = "/ratings/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<?>> doSaveRating(@RequestBody RatingSaveRequest request) throws JsonProcessingException {
        BaseResponse<RatingSaveResponse> response = new BaseResponse<>();
        response = ratingService.saveRating(request);
        return ResponseEntity.ok(response);
    }
    
}
