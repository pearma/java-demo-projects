package com.pearma.vuebackenddemo.repository;

import java.util.List;


import com.pearma.vuebackenddemo.model.SystemInfo;
import com.pearma.vuebackenddemo.dto.SystemInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface SystemInfoRepository extends JpaRepository<SystemInfo,Integer>{

    @Query(value="SELECT id,system_id,system_short_name,system_full_name FROM systeminfo", nativeQuery = true)
    List<SystemInfo> findAll();
    @Query("SELECT new com.pearma.vuebackenddemo.dto.SystemInfoDTO(s.id,s.systemId,s.systemFullName,s.systemShortName) FROM SystemInfo s")
	public List<SystemInfoDTO> findAllDTO();    
}
