package pl.edu.utp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println(principal);
		return principal;
	}

}
