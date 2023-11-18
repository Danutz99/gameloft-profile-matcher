package gameloft.interview.profilematcher.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProfileMatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileMatcherApplication.class, args);
	}

}
