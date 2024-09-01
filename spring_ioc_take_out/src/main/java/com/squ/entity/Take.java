package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Take {
    private String UserID;
    private String UserName;
    private String Address;
    private String Password;
    private String UserPhone;

}
