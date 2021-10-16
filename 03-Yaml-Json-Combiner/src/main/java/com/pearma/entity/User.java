package com.pearma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonRawValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    @JsonRawValue
    private String userProfile;
}
