package com.prodip.SpringJDBCDemo;

import com.prodip.SpringJDBCDemo.model.Alien;
import com.prodip.SpringJDBCDemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(328);;
		alien1.setName("Podip");
		alien1.setTech("Java");


		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);

		//System.out.println(repo.findAll());		// eita use korle ek line a sob choele ashbe.  jeta dekhte valo lage na.

		repo.findAll().forEach(a -> System.out.println(a));    // eita use korle output line by line ashbe ektar niche ekta


	}

}

