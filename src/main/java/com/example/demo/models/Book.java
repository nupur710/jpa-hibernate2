package com.example.demo.models;

import jakarta.persistence.*;

//mapped to DB table

/**
 * This class will not be picked up by IOC container (it is not present in spring context jar)
 *  but by hibernate (present in jpa jar) therefore no @component annotation but @entity
 */

@Entity
//if we want table in db to have another name @Table(name="my_book")
public class Book {
	//primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//if we want mysql server to assign id GenerationType.IDENTITY

	/**
	 *
	 * Hibernate insert (hibernate cannot keep count on how many entiries have been inserted into each table
	 * insert first entry into table 1 id-> 1
	 * insert first entry into table 2 id -> 2
	 * insert second entry into table 1 id -> 3
	 *
	 * MySql insert (keeps count on how many entires have been inserted into each table
	 * insert first entry into table 1 id-> 1
	 * insert first entry into table 2 id-> 1
	 * insert second entry into table 1 id-> 2
	 *
	 */



	private int id;
	//if we want column in db to have another name @Column(name="book_name")
	private String name;
	private String authorsName;
	private int cost;
	@ManyToOne //many books are mapped to one category
	//we only want to map with id column i.e. primary key column
	/**
	 * in this table we want foreign key as book category id; we do this by
	 * using @join which maps this property  to primary key on bookCategory
	 */
	//foreign key
	@JoinColumn
	private BookCategory bookCategory;

	public Book() {}

	public Book(String name, String authorsName, int cost) {
		this.name= name;
		this.authorsName= authorsName;
		this.cost= cost;
	}

	public Book(String name, String authorsName, int cost, int bookCategoryId) {
		this.name= name;
		this.authorsName= authorsName;
		this.cost= cost;
		//in order to set bookcategory.setId we first need to initialize book category obj otherwise it will be empty
		this.bookCategory= new BookCategory();
		this.bookCategory.setId(bookCategoryId);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorsName() {
		return authorsName;
	}
	public void setAuthorsName(String authorsName) {
		this.authorsName = authorsName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "{ " + this.getId() + " " + this.getName() + " " + this.getAuthorsName() + " " + this.getCost()+ "}";
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
}
