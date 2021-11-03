package com.pearma.vuebackenddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SystemInfoDTO {
 
    private Integer id;
    private String systemId;
    private String systemFullName;
    private String systemShortName;

    public SystemInfoDTO(Integer id,String systemFullName)
    {
        this.id=id;
        this.systemFullName=systemFullName;
    }
}
