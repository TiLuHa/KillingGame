package iz.netwerk.src;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import iz.netwerk.src.Model.Account;
import iz.netwerk.src.Model.AccountRoles;
import iz.netwerk.src.repositories.AccountRepository;

@SpringBootApplication
@EnableConfigurationProperties
public class KillingGameApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KillingGameApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KillingGameApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Account tmp = new Account("Admin", encoder.encode("admin"), "admin@admin.admin");
		tmp.addRole(AccountRoles.ADMIN);
		repo.save(tmp);
	}
	
    // Fix the CORS errors
    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true); 
        // *** URL below needs to match the Vue client URL and port ***
        config.setAllowedOrigins(Collections.singletonList("*")); 
        config.setAllowedMethods(Collections.singletonList("*"));  
        config.setAllowedHeaders(Collections.singletonList("*"));  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    }
}