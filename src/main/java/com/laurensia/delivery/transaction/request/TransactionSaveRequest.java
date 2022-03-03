package com.laurensia.delivery.transaction.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionSaveRequest {

    private Long idUser;

    private Long idItem;
    
    private Integer countItem;
    
    private String status;
}
