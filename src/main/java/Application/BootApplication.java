package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootApplication {

    private static final Logger log = LoggerFactory.getLogger(BootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return (args) -> {

            repository.save(new Student("Omar",127345));
            repository.save(new Student("Jack", 246898));
            repository.save(new Student("Riley", 123124));
            repository.save(new Student("Andrew", 123123));
            repository.save(new Student("Logan",123987));

            log.info("Students found with findAll():");
            log.info("-------------------------------");

            for (Student student : repository.findAll()) {
                log.info(student.toString());
            }

            log.info("");
        };
    }
}