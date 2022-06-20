/*
========================================================================
파    일    명 : ControllerConfig.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : Controller 빈 등록
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.05.05
수  정  내  용 : MainController -> PetListController 로 이름 변경
========================================================================
*/
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.AdminController;
import controller.AdminManagementController;
import controller.MainController;

@Configuration
public class ControllerConfig {

	@Bean
	public MainController mainController() {
		return new MainController();
	}
//	@Bean
//	public KeepController keepController() {
//		return new KeepController();
//	}
//	@Bean
//	public ReceiptController receiptController() {
//		return new ReceiptController();
//	}
	
	@Bean
	public AdminController adminController() {
		return new AdminController();
	}
	
	@Bean
	public AdminManagementController adminManagementController() {
		return new AdminManagementController();
	}

}