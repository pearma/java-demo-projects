package com.pearma.vuebackenddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionListInfo {

    private String publisherId;
    private String listFile;
    private String srcFile;

}
