package com.eeeffff.monitor.eklogmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author fenglibin
 */
@SpringBootApplication(scanBasePackageClasses={ServiceApplication.class})
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}
