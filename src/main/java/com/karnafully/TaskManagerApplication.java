package com.karnafully;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karnafully.model.Assignee;
import com.karnafully.repository.AssigneeRepo;
import com.mysql.fabric.xmlrpc.base.Data;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {
	@Autowired
	private AssigneeRepo assigneeRepo; 
	
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		assigneeRepo.save(new Assignee("Avishek", "avishek_barua@yahoo.com", df.parse("29/04/2018"), "resources/buddha.jpg"));
		assigneeRepo.save(new Assignee("Amit", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Shanta", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Dimple", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Deepa", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Mohor", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Adi", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Haimanti", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Regan", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Pranto", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Mishu", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Manojit", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		assigneeRepo.save(new Assignee("Piplu", "amitsletterbox@gmail.com", df.parse("01/05/2018"), "resources\\buddha.jpg"));
		
		assigneeRepo.findAll().forEach( e-> {
			System.out.println(e.getName());
		});
	}
}
