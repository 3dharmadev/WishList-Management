package com.addtowishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.addtowishlist.repositories", "other.package"})
public class WishlistManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishlistManagementApplication.class, args);
	}

}
