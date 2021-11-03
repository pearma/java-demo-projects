package com.pearma.vuebackenddemo.service.impl;

import java.util.List;

import com.pearma.vuebackenddemo.dto.SystemInfoDTO;
import com.pearma.vuebackenddemo.model.SystemInfo;
import com.pearma.vuebackenddemo.repository.SystemInfoRepository;
import com.pearma.vuebackenddemo.service.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private SystemInfoRepository repository;

    @Override
    public List<SystemInfo> queryForSystems() {
        return repository.findAll();
    }

    @Override
    public List<SystemInfoDTO> queryForSystemDTOs() {
        return repository.findAllDTO();
    }
}
