package com.woowacourse.open_mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class OpenMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenMissionApplication.class, args);
	}

}
