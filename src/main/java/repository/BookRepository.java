package repository;

import entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);

    List<BookEntity> findByNameAndAuthor(String name, String author);

    List<BookEntity> findByNameOrAuthor(String name, String author);

    List<BookEntity> findByBookDetailsPriceLessThan(int price);

    List<BookEntity> findByNameContaining(String name);

    @Query(value = "select * from book", nativeQuery = true)
    List<BookEntity> getAll();

    List<BookEntity> findByBookDetailsIsbn(String isbn);

    @Query("select b from BookEntity b where b.name like ?1%")
    List<BookEntity> getBookNameStartWith(String name);
    @Query("select b from BookEntity b where b.bookDetails.price > ?1")
    List<BookEntity> getBookPriceGreaterThan(int price);
}
