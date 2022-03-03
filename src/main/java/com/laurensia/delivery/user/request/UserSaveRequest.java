package com.laurensia.delivery.user.request;

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
public class UserSaveRequest {

    private String name;

    private String gender;
    
    private String phone;
    
    private String ic;
    
    private String email;
    
    private String address;

    private String password;
    
    private String role;

}
