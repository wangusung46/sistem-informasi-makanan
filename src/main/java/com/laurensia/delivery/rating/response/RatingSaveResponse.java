package com.laurensia.delivery.rating.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RatingSaveResponse {

    private Long idTransaction;

    private Integer rate;
    
    private String review;

}
