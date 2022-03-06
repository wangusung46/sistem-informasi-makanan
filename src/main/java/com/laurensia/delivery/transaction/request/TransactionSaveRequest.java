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
public class TransactionSaveRequest {

    private Long idItem;
    
    private Integer countItem;
    
    private String status;
}
