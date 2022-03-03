package com.laurensia.delivery.item.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemSaveResponse {

    private String name;

    private Integer price;
    
    private Integer stock;
    
    private Boolean active;

}
