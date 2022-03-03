package com.laurensia.delivery.rating.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RatingSaveRequest {

    private Long id_transaction;

    private Integer rate;
    
    private String review;
}
