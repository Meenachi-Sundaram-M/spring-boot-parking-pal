package com.augusta.springboot.Parking.control.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ParkingSecurity {

	@Bean
	public UserDetailsManager userdetailmanager(DataSource datasource) {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

		jdbcUserDetailsManager
				.setAuthoritiesByUsernameQuery("select username,password,enabled from users where username=?;");
		jdbcUserDetailsManager
				.setAuthoritiesByUsernameQuery("Select username,authority from authorities where username=?;");
		return jdbcUserDetailsManager;

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer
			    .requestMatchers(HttpMethod.GET, "/api/slot/**").hasRole("ADMIN")
			    .requestMatchers(HttpMethod.GET, "/api/vehicleinfo").hasRole("ADMIN")
			    .requestMatchers(HttpMethod.GET, "/api/slotinfo").hasRole("ADMIN")
			    .requestMatchers(HttpMethod.GET, "/api/bikeslotinfo").hasRole("ADMIN")
			    .requestMatchers(HttpMethod.GET, "/api/get/dashboard").hasAnyRole("ADMIN","USER")
			    .requestMatchers(HttpMethod.POST, "/api/book/parking").hasAnyRole("ADMIN","USER")
			    .requestMatchers(HttpMethod.PUT, "/api/car/unpark/**").hasAnyRole("ADMIN","USER")
			    .requestMatchers(HttpMethod.PUT, "/api/bike/unpark/**").hasAnyRole("ADMIN","USER")

			);


		http.httpBasic(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());

		return http.build();

	}

}
