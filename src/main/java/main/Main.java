package main;

import configuration.JPAConfig;
import entity.BookDetailsEntity;
import entity.BookEntity;
import entity.CategoryEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;
import repository.CategoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository");

    public static void main(String[] args) {
       createNewBookEntryWithNewCategory();
       createNewBookEntity();
      //  findByAuthor("Leo");
       // findByNameAndAuthor("Java all 1", "Tomy");
      // findByNameOrAuthor("Java all_1", "Tomy");
      //  findByPriceLessThan(10);
      //  findByNameContaining("Java all");
      //  findAllUsingQuery();
      //  findByBookDetailsIsbn("ISIIBF12193235");
      //  getBookNameStartWithusingQuery("Java all");
        findBookPriceGreaterThanUsingQuery(24);

    }
    public static void findByAuthor(String author){
        List<BookEntity> bookEntityList = bookRepository.findByAuthor(author);
        if (bookEntityList != null){
            System.out.println("\nFind" + bookEntityList.size() + "books which author = " + author);
            for (BookEntity bookEntity: bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameAndAuthor(String name, String author){
        List<BookEntity> bookEntityList = bookRepository.findByNameAndAuthor(name,author);
        if (bookEntityList != null){
            System.out.println("\nFind" + bookEntityList.size() + "books which name and author = "+ name +" and "+ author);
            for (BookEntity bookEntity: bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameOrAuthor(String name, String author){
        List<BookEntity> bookEntityList = bookRepository.findByNameOrAuthor(name,author);
        if (bookEntityList != null){
            System.out.println("\nFind" + bookEntityList.size() + "books which name or author = "+ name +" or "+ author);
            for (BookEntity bookEntity: bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByPriceLessThan(int price){
        List<BookEntity> bookEntityList = bookRepository.findByBookDetailsPriceLessThan(price);
        if (bookEntityList != null){
            System.out.println("\nFind " + bookEntityList.size() + " books which price = "+ price);
            for (BookEntity bookEntity: bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameContaining(String name){
        List<BookEntity> bookEntityList = bookRepository.findByNameContaining(name);
        if(bookEntityList != null){
            System.out.println("\nFind " + bookEntityList.size() + " books which name = "+ name);
            for (BookEntity bookEntity: bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
        }
      public static void findAllUsingQuery(){
        List<BookEntity> bookEntityList = bookRepository.getAll();
          if(bookEntityList != null){
              System.out.println("\nFind " + bookEntityList.size() + " books = ");
              for (BookEntity bookEntity: bookEntityList){
                  System.out.println(bookEntity.toString());
              }
          }
      }
      public static void findByBookDetailsIsbn(String isbn){
        List<BookEntity> bookEntityList = bookRepository.findByBookDetailsIsbn(isbn);
        if(bookEntityList != null){
            System.out.println("\nFind book which isbn = " +isbn);
            System.out.println(bookEntityList.toString());
        }
      }
      public  static void getBookNameStartWithusingQuery(String name){
        List<BookEntity> bookEntityList = bookRepository.getBookNameStartWith(name);
        if(bookEntityList != null) {
            System.out.println("\nFind " +bookEntityList.size() +" books");
            for (BookEntity bookEntity : bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
      }public static void findBookPriceGreaterThanUsingQuery(int price){
        List<BookEntity> bookEntityList = bookRepository.getBookPriceGreaterThan(price);
        if (bookEntityList != null){
            System.out.println("\nFind " +bookEntityList.size()+ " books");
            for (BookEntity bookEntity: bookEntityList){
                System.out.println(bookEntity.toString());
            }
        }
      }
    public static void createNewBookEntity() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }

    public static void createNewBookEntryWithNewCategory() {
        CategoryEntity categoryEntity = createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }

    private static CategoryEntity createNewCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Java");
        categoryEntity.setDescription("Java books");
        return categoryEntity;
    }

    private static BookEntity createNewBook() {
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("ISIIBF12193235");
        bookDetailsEntity.setPrice(26);
        bookDetailsEntity.setNumberofPage(13);
        bookDetailsEntity.setPublishDate(LocalDate.now());

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Java all");
        bookEntity.setAuthor("Tomy");
        bookEntity.setBookDetails(bookDetailsEntity);
        bookDetailsEntity.setBook(bookEntity);

        return bookEntity;
    }

    }


