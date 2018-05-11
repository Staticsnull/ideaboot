package cn.bdqn.common;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class CommonsFileUploadBean {


    @Bean
    public MultipartConfigElement getFileUpload(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("20MB");
        factory.setMaxRequestSize("512kb");
        return factory.createMultipartConfig();
    }




}
