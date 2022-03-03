package com.laurensia.delivery.transaction.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionSaveResponse {

    private Long idUser;

    private Long idItem;
    
    private Integer countItem;
    
    private String status;

}
