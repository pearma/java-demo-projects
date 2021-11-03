package com.pearma.vuebackenddemo.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import com.pearma.vuebackenddemo.dto.SubscriptionListInfo;
import com.pearma.vuebackenddemo.dto.SystemInfoDTO;

import com.pearma.vuebackenddemo.service.QueryService;

@Slf4j
@RestController
@CrossOrigin
public class QueryController {

    @Autowired
    private QueryService qs;

    @GetMapping("/sys")
    public List<SystemInfoDTO> querySystem() {
        log.info("system info query triggered!");
        List<SystemInfoDTO> result = qs.queryForSystemDTOs();
        log.info("num of result : {}", result.size());
        result.forEach(x -> log.info(x.toString()));
        return result;

    }

    @GetMapping("/tomap")
    public Object tomap() {
        List<SubscriptionListInfo> queryRecs = new ArrayList<>();
        queryRecs.add(new SubscriptionListInfo("zh-100", "a.list", "1.txt"));
        queryRecs.add(new SubscriptionListInfo("zh-100", "a.list", "2.txt"));
        queryRecs.add(new SubscriptionListInfo("zh-100", "b.list", "3.txt"));
        queryRecs.add(new SubscriptionListInfo("zh-100", "b.list", "4.txt"));
        queryRecs.add(new SubscriptionListInfo("zh-101", "c.list", "5.txt"));
        queryRecs.add(new SubscriptionListInfo("zh-101", "c.list", "6.txt"));
        
        //按publisher进行分组
        Map<String, List<SubscriptionListInfo>> publisherGroup = queryRecs.stream()
                .collect(Collectors.groupingBy(x -> x.getPublisherId()));
        //根据分组，进行遍历，同时进行第2轮分组
        //2轮分组根据信号文件名
        Map<String,Map<String,List<String>>> listGroup = publisherGroup.keySet().stream().map(key -> {

            Map<String, List<SubscriptionListInfo>> srcGroup=publisherGroup.get(key).stream().collect(Collectors.groupingBy(l -> l.getListFile()));

            Map<String,List<String>> listSrcMap = srcGroup.entrySet().stream().map(
                e -> {
            //获取信号文件名下的源文件清单
                List<String> srcFiles = e.getValue().stream().map(s -> s.getSrcFile())
                        .collect(Collectors.toList());
                return new AbstractMap.SimpleEntry<>(e.getKey(), srcFiles);
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            return new AbstractMap.SimpleEntry<>(key, listSrcMap);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return listGroup;

    }

    @GetMapping("/file")
    public void writeFile() {
        byte[] a = new byte[4096];

        try {
            FileInputStream fis = new FileInputStream(new File("pom.xml"));
            a = fis.readAllBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(a);
            FileOutputStream fos = new FileOutputStream(new File("pom.xml.bak"));
            String comment = "abcl";

            ByteArrayInputStream bais2 = new ByteArrayInputStream(comment.getBytes());
            IOUtils.copy(bais, fos);
            IOUtils.copy(bais2, fos);
            bais.close();
            bais2.close();
            fos.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
