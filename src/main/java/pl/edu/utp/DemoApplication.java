package pl.edu.utp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println(principal);
		return principal;
	}

	@RequestMapping("/user2")
	public String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.isAuthenticated())
			return auth.getName();
		else
			return null;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/test")
	public String test(){
		return "TEST!!!!!!!!!!1";
	}


}
