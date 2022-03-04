package com.laurensia.delivery.transaction.response;

public interface TransactionDetailResponse {

    Long getId();

    String getNameUser();
    
    String getNameItem();
    
    Integer getCountItem();
    
    String getStatus();
    
    Integer getTotal();
    
    Integer getRate();
    
    String getReview();

}
