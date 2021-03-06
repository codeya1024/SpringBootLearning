package com.codeya.springboot.main;

import com.codeya.springboot.testyml.TokenFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages="com.codeya.springboot")
@MapperScan(basePackages="com.codeya.springboot.**.dao")
@EnableSwagger2
@EnableDiscoveryClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//@Bean
	TokenFilter tokenFilter() {
		return new TokenFilter( );
	}
}
