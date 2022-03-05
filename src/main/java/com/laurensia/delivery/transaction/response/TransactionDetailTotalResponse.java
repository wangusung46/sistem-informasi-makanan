package com.laurensia.delivery.transaction.response;

import java.math.BigDecimal;

public interface TransactionDetailTotalResponse {

    Long getId();
    
    String getNameItem();
    
    Integer getPrice();
    
    Integer getCountItem();
    
    String getStatus();
    
    Integer getTotal();
    
    BigDecimal getRate();

}
