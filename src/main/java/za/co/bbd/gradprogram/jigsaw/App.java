package za.co.bbd.gradprogram.jigsaw;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.bbd.gradprogram.jigsaw.db.TargetImageJdbcRepository;

@SpringBootApplication
public class App {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TargetImageJdbcRepository repository;

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(App.class, args);
    }
}
