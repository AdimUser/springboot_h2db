package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {
	
	public static Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	static JdbcRepository db_updates = new JdbcRepository() ;
	static UserRowMapper db_list = new UserRowMapper();
	
    public static void main(String[] args) {
        SpringApplication.run(hello.Application.class, args);
        log.info("Creating table");
        log.info("User id 10001 -> {}", db_updates.findById(10001));
        log.info("Inserting -> {}", db_updates.insert(new Greeting(10011, "John1")));
        log.info("All users 1 -> {}", db_list.findAll());
        
    }
    

}
