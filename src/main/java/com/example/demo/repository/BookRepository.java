package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;

import java.util.List;

//for db operations

public interface BookRepository extends JpaRepository<Book, Integer> {
	/**you can define this method either in impl class (see: BookRepositoryImpl)
	 * or you can use @Query annotation
	 * @param name
	 * @return
	 */
//	@Query("select * from book where book.name= name")
//	List<Book> findByName(String name);

	//findBy{columnName} i.e. findBy{property}
	public List<Book> findByauthorsName(String name);
	public List<Book> findByCost(int cost);
	public Book findById(int id);

	//if we want to use a findBy{notColumnName}
	//native sql query
	@Query(value = "select * from Book b where b.authors_name=:my_name", nativeQuery = true)
	public List<Book> findByauthor(String my_name);

	//jpql query
	@Query(value = "select b from Book b where b.authorsName=:my_name")
	public List<Book> findByauthors(String my_name);


}
