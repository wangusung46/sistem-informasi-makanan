package com.laurensia.delivery.item.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemSaveRequest {

    private String name;

    private Integer price;

    private Integer stock;
}
