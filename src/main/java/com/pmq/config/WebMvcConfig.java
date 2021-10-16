package com.pmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	// 이미지 저장
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 // http://localhost//images/qwer_2389283923/alien.png -> 를 넣어줌
		registry.addResourceHandler("/images/**") 
		// 실제 파일 저장 위치  (=file:///(윈도우일때..!)FileManagerService.FILE_UPLOAD_PATH/) 
		 .addResourceLocations("file:///D:\\웹개발(21-05-20)\\pmq\\pmq_workspace\\images/");
	}
}
