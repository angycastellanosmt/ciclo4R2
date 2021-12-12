package co.edu.usa.ciclo4.retodos;

import co.edu.usa.ciclo4.retodos.repository.crud.GadgetCrudRepository;
import co.edu.usa.ciclo4.retodos.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
	public static void main(String[] args) {
		SpringApplication.run(RetodosApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception{
        gadgetCrudRepository.deleteAll();
        userCrudRepository.deleteAll();

}
}
