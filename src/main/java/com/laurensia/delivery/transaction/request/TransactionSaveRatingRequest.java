package com.laurensia.delivery.transaction.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionSaveRatingRequest {

    private Long idTransaction;
    
    private Integer rate;
    
    private String review;
}
