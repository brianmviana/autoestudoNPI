package br.ufc.npi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AutoestudoApplication extends SpringBootServletInitializer {
	
	@Override 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AutoestudoApplication.class);
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AutoestudoApplication.class, args);
	}
}
