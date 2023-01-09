package me.mrsofiane.demographql;

import me.mrsofiane.demographql.entities.Student;
import me.mrsofiane.demographql.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphqlApplication.class, args);
	}


	@Bean
	CommandLineRunner start(StudentRepository studentRepository){
		return args -> {
			Student student1 = Student.builder().name("djelul").email("djelul@email.com").build();
			Student student2 = Student.builder().name("hamid").email("hamid@email.com").build();
			Student student3 = Student.builder().name("alawa").email("alawa@email.com").build();

			studentRepository.saveAll(List.of(student1, student2, student3));

		};
	}
}
