package com.example.demo.models;


import jakarta.persistence.*;

import java.util.Iterator;
import java.util.Set;

@Entity
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    //one to many mapping. If it was a one-one mapping private Book book;
    @OneToMany (mappedBy = "bookCategory", cascade = CascadeType.ALL)
    /**
     * Cascasde type defines parent-child relationship
     * All- all changes made in parent table are reflected in child db
     * for eg. if id is updated in parent table
     */
    private Set<Book> books;

    public BookCategory() {}

    public BookCategory(String name) {
        this.name= name;
    }

    public BookCategory(String name, Set<Book> books) {
        this.name= name;
        this.books= books;
        this.books.forEach(x -> x.setBookCategory(this));

//        Iterator it= books.iterator();
//        while(it.hasNext()) {
//            Book book= (Book)it.next();
//            book.setBookCategory(this);
//        }
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
