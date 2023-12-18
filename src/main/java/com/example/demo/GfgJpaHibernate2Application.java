package com.example.demo;

import com.example.demo.models.BookCategory;
import com.example.demo.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication(scanBasePackages= {"models", "repository" })
public class GfgJpaHibernate2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GfgJpaHibernate2Application.class, args);
	}
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Override
	//since this function is run whenever application starts, you can use this function
	//to do startup work or test apis e.g., clean temporary files
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Book b1= new Book("The Prince", "Henry", 6);
		Book b2= new Book("50 Rules for Power", "Paul", 9);
		Book b3= new Book("Secrets of Money", "Paul", 8);
		Book b4= new Book("The Whispering Horse", "Les", 10);
		List<Book> b= new ArrayList<>();
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);

//		b.setId(7);
//		b.setName("The Order of Phoenix");
//		b.setAuthorsName("Joanne");
//		b.setCost(8);
//		bookRepository.saveAll(b);
//		System.out.println(bookRepository.findAll());
//		System.out.println(bookRepository.findByauthorsName("Paul"));
//		System.out.println(bookRepository.findByCost(6));
//		System.out.println(bookRepository.findById(4));
//		System.out.println(bookRepository.findByauthor("Henry"));
//		System.out.println(bookRepository.findByauthors("Paul"));

        Set<Book> books= new HashSet<>();
		Book bookOne= new Book("Contratian", "Christopher", 20);
		Book bookTwo= new Book("History", "Yuval", 15);
		books.add(bookOne);
		books.add(bookTwo);
		bookCategoryRepository.save(new BookCategory("Non-Fiction"));
		//saving books in bookcategory also saves them in book table because of cascading behavior
		bookCategoryRepository.save(new BookCategory("Fiction", books));

		Book b5= new Book("Java", "Laura", 6, 1);
		bookRepository.save(b5);

	}

}
