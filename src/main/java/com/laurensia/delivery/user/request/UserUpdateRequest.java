package com.laurensia.delivery.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserUpdateRequest {

    private String name;

    private String gender;
    
    private String phone;
    
    private String ic;
    
    private String address;

    private String password;

}
