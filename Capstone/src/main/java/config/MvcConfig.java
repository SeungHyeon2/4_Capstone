/*
========================================================================
파    일    명 : MvcConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.29
작  성  내  용 : 스프링 MVC 설정
========================================================================
*/
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ParcelProject.service.impl"})
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/list").setViewName("list/petList");

	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//
//	}

}