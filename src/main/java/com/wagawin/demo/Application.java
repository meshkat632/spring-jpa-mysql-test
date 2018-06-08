package com.wagawin.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.wagawin.demo.model.Child;
import com.wagawin.demo.model.Daughter;
import com.wagawin.demo.model.House;
import com.wagawin.demo.model.HouseType;
import com.wagawin.demo.model.Meal;
import com.wagawin.demo.model.Person;
import com.wagawin.demo.model.Son;
import com.wagawin.demo.repository.ChildRepository;
import com.wagawin.demo.repository.ParentSummaryRepository;
import com.wagawin.demo.repository.PersonRepository;

import io.bloco.faker.Faker;

@SpringBootApplication
@EnableJpaAuditing
/*
@EnableScheduling

*/


public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private static Random randomGenerator = new Random();

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	
	private static List<Child> creatChildren(Faker faker, int numberOfChildren) throws ParseException {
		List<Child> children = new ArrayList<Child>();
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < numberOfChildren; i++) {
			boolean randomBool = randomGenerator.nextBoolean();
			if (randomBool) {
				Son son1 = new Son();
				son1.setBiCycleColor(faker.color.colorName());
				son1.setAge(faker.number.between(0, 10));
				son1.setName(faker.name.firstName());
				son1.setFavoriteMeals(Arrays.asList(
						new Meal(faker.food.dish(), faker.date.between(df.parse("01/01/2001"), df.parse("30/31/2018"))),
						new Meal(faker.food.dish(),
								faker.date.between(df.parse("01/01/2001"), df.parse("30/31/2018")))));
				children.add(son1);
			} else {
				Daughter daughter1 = new Daughter();
				daughter1.setHairColor(faker.color.colorName());
				daughter1.setAge(faker.number.between(0, 10));
				daughter1.setName(faker.name.firstName());
				daughter1.setFavoriteMeals(Arrays.asList(
						new Meal(faker.food.dish(), faker.date.between(df.parse("01/01/2001"), df.parse("30/31/2018"))),
						new Meal(faker.food.dish(),
								faker.date.between(df.parse("01/01/2001"), df.parse("30/31/2018")))));
				children.add(daughter1);
			}
		}
		return children;

	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, ChildRepository childRepository,
			ParentSummaryRepository parentSummaryRepository) {
		return (args) -> {
			Faker faker = new Faker();
			
			for (int i = 0; i < 10; i++) {				
				Person person = new Person();
				person.setAge(faker.number.between(20, 100));
				person.setName(faker.name.firstName());

				House home = new House();
				home.setAddress(faker.address.streetAddress());
				home.setZipCode(faker.address.postcode());
				int houseType = faker.number.between(0, 2);
				if (houseType == 0)
					home.setHouseType(HouseType.FLAT);
				else if (houseType == 1)
					home.setHouseType(HouseType.ESTATE);
				else if (houseType == 2)
					home.setHouseType(HouseType.HOUSE);
				person.setHouse(home);
				person.setChildren(creatChildren(faker, faker.number.between(0,  5)));
				personRepository.save(person);
			}		
			
		};
	}	
	

}