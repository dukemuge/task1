package com.pezesha.task;

import com.pezesha.task.models.User;
import com.pezesha.task.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	//Test spring authentication for Testing purpose
	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User(1L,"user",encoder.encode("password"),"ROLE_USER"));
			users.save(new User(2L,"admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));
		};
	}

}
