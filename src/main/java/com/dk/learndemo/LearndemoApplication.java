package com.dk.learndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: zhudakang
 * @Description : 所有的对整个项目的注解和应用，需要加载这个类的头上
 * @Date: 2019/5/30 17:31
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class LearndemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearndemoApplication.class, args);
	}

}
