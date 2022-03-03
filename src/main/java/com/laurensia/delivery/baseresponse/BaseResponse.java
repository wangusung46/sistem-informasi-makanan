/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laurensia.delivery.baseresponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Khanza
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BaseResponse<T> {
    private boolean status;
    private T payload;
}
