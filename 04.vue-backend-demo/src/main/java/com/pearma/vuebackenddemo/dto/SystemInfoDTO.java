package com.pearma.vuebackenddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
