package com.laurensia.delivery.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Riyad
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserLoginRequest {

    private String email;

    private String password;

}
