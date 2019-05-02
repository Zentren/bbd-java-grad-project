package za.co.bbd.gradprogram.jigsaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.bbd.gradprogram.jigsaw.TargetImage;
import za.co.bbd.gradprogram.jigsaw.TargetImageJdbcRepository;

@SpringBootApplication
public class App {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TargetImageJdbcRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
	public void run(String... args) throws Exception {

		logger.info("Inserting -> {}", repository.insert(new TargetImage(10001L, new byte[] {})));
		logger.info("Inserting -> {}", repository.insert(new TargetImage(10010L, new byte[] {})));

		logger.info("Update 10003 -> {}", repository.update(new TargetImage(10001L, new byte[] {})));

		repository.deleteById(10001L);

		logger.info("All users -> {}", repository.findAll());
	}
}
