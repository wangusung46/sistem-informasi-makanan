package com.laurensia.delivery.item.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemDetailResponse {
    
    private Long id;

    private String name;

    private Integer price;
    
    private Integer stock;
    
    private Boolean active;

}
