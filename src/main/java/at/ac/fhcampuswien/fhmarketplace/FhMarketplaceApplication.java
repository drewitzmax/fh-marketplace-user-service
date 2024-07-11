package at.ac.fhcampuswien.fhmarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FhMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FhMarketplaceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://web-dot-authwfp1.oa.r.appspot.com/","http://localhost:4200", "http://localhost:8080");
			}
		};
	}

}
