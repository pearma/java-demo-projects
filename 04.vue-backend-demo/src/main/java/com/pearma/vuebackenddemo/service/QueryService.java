package com.pearma.vuebackenddemo.service;

import java.util.List;

import com.pearma.vuebackenddemo.dto.SystemInfoDTO;
import com.pearma.vuebackenddemo.model.SystemInfo;

public interface QueryService {
    
    List<SystemInfo>     queryForSystems();
    List<SystemInfoDTO>  queryForSystemDTOs();
}
