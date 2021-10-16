package com.pearma.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pearma.entity.User;
import com.pearma.entity.UserProfile;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import org.yaml.snakeyaml.constructor.Constructor;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public enum UserUtil {
    INSTANCE;
    private UserUtil() {
        System.out.println("UserUtil created!");
    }

    public String getProfile(String userName)
    {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.FLOW);
        Yaml yamlIn = new Yaml(new Constructor(UserProfile.class));
        Yaml yamlOut = new Yaml(options);
        InputStream inputStream = this.getClass()
          .getClassLoader()
          .getResourceAsStream(userName+".profile");
        UserProfile up=yamlIn.load(inputStream);
        
        return yamlOut.dump(up);
    }

    public void exportJson(User u,String userName,String outputFile)
    {       
        u.setUserProfile(String.format("\"%s\"",getProfile(userName).trim()));  
        
        try( FileWriter output = new FileWriter(outputFile);) {
            //result = new ObjectMapper().writeValueAsString(u);
            new ObjectMapper().writeValue(output, u);
            log.info("exported!");            
            

        } catch (JsonProcessingException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }


        return;
    }
}
