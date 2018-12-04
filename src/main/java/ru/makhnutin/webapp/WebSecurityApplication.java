package ru.makhnutin.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.makhnutin.webapp.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"ru.makhnutin.webapp"})
public class WebSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebSecurityApplication.class, args);
	}
}
