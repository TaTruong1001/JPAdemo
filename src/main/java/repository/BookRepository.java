package repository;

import entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
   List<BookEntity> findByAuthor(String author);
    @Query("Select b from BookEntity b where b.name like ?1%")
    List<BookEntity> getBookNameStartWith(String name);
    @Query(value = "select * from book  where price < ?1 and numberPage >= ?2", nativeQuery = true)
    List<BookEntity>  getBookWherePriceLessThanAndNumberOfPageGreaterThan(double price, int numberPage);
}
