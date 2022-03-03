package com.laurensia.delivery.user.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDetailResponse {
    
    private Long id;

    private String name;

    private String gender;
    
    private String phone;
    
    private String ic;
    
    private String email;
    
    private String address;
    
    private Boolean active;

}
