package br.com.lab.orders.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("br.com.lab.orders.repositories.interfaces")
@ComponentScan({
		"br.com.lab.orders.api.services",
		"br.com.lab.orders.services"
		})
@EntityScan("br.com.lab.orders.repositories.entities")
public class OrderConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
