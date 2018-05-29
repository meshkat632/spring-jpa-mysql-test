package com.wagawin.demo;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.wagawin.demo.model.Child;
import com.wagawin.demo.model.House;
import com.wagawin.demo.model.HouseType;
import com.wagawin.demo.model.Meal;
import com.wagawin.demo.model.Person;
import com.wagawin.demo.repository.ChildRepository;
import com.wagawin.demo.repository.PersonRepository;

import io.bloco.faker.Faker;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo( PersonRepository personRepository, ChildRepository childRepository) {
		return (args) -> {
			
			personRepository.deleteAll();
			childRepository.deleteAll();
			
			Faker faker = new Faker();
			faker.name.firstName();    // Returns "Aaron"
			faker.company.name();      // Returns "Hirthe-Ritchie"
			
			Person person = new Person();
			person.setAge(25);
			person.setName("ola");
			
			Child Child1 = new Child();
			Child1.setAge(2);
			Child1.setName("Child1");
			Child1.setFavoriteMeals(Arrays.asList(new Meal("IceCream", new Date() ), new Meal("Pizza", new Date() )));
			
			Child Child2 = new Child();
			Child2.setAge(2);
			Child2.setName("Child2");
			Child2.setFavoriteMeals(Arrays.asList(new Meal("IceCream", new Date() ), new Meal("Pizza", new Date() )));
			
			Child Child3 = new Child();
			Child3.setAge(3);
			Child3.setName("Child3");
			Child3.setFavoriteMeals(Arrays.asList(new Meal("IceCream", new Date() ), new Meal("Pizza", new Date() )));
			
			House home = new House();
			home.setAddress("Agnes Baer");
			home.setZipCode("80687");
			home.setHouseType(HouseType.FLAT);
			person.setHouse(home);
			
			person.setChildren(Arrays.asList(Child1, Child2, Child3));
			
			/*
			childRepository.save(Child1 );
			childRepository.save(Child2 );
			*/
			personRepository.save(person );
			
			/*
			for(int i = 0; i< 1000; i++) {
				repository.save(new Customer(faker.name.firstName(), faker.name.lastName()));
			}

			*/
			/*
			
			for(int i = 0; i< 10; i++) {
				repository.save(new PrivateCustomer(faker.name.firstName(), faker.name.lastName(),faker.phoneNumber.cellPhone()));
			}
			
			
 
			
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
			*/
		};
	}

}