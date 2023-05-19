package main;

import configuration.JPAConfig;
import entity.BookEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

    public static void main(String[] args) {
        System.out.println("Hello");
    }


//    private static void createNewBook(){
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setName("Tomy");
//        bookEntity.setAuthor("Alex");
//        bookEntity.setCategory("IT books");
//        bookEntity.setIsbn("ISIBF219323");
//        bookEntity.setNumberPage(234);
//        bookEntity.setPrice(20.5);
//
//
//        BookEntity result = bookRepository.save(bookEntity);
//
//
//       if (result != null){
//           System.out.println("A new book saved successfully, book Id = " +bookEntity.getId());
//       }
//
//    }
//    private static void readBook(){
//        List<BookEntity> bookList = (List<BookEntity>) bookRepository.findAll();
//        System.out.println("Found" +bookList.size() +"book(s) in the table book");
//        System.out.println("They are");
//        for (BookEntity book: bookList)
//            System.out.println(book.toString());
//    }
//    private static void readBook(int bookId){
//        BookEntity bookEntity = bookRepository.findById(bookId).get();
//        if (bookEntity != null){
//            System.out.println("Found a book with book ID = "+bookId);
//            System.out.println(bookEntity.toString());
//        }else {
//            System.out.println("not found " +bookId);
//        }
//
//    }
//    private static void updateBook(int id){
//        Optional<BookEntity> bookEntity = bookRepository.findById(id);
//        if (bookEntity.isPresent())
//        System.out.println("Book data before updating");
//        System.out.println(bookEntity.toString());
//
//        BookEntity bookEntity1 = bookEntity.get();
//        bookEntity1.setAuthor("leo");
//        bookEntity1.setNumberPage(199);
//        bookEntity1.setPrice(25);
//        bookRepository.save(bookEntity1);
//
//        System.out.println("Book data after updating");
//        System.out.println(bookEntity.toString());
//    }
//    private static void deteleBook(int id){
//        Optional<BookEntity> bookEntity = bookRepository.findById(id);
//        if (bookEntity.isPresent());
//        bookRepository.delete(bookEntity.get());
//
//    }
//    private static void findByAuthor(String author) {
//        List<BookEntity> bookList = (List<BookEntity>) bookRepository.findByAuthor(author);
//        if (bookList.size() != 0) {
//            System.out.println("They are");
//            for (BookEntity book : bookList) {
//                System.out.println(book.toString());
//            }
//        }
//    }
//    public static void getBookNameStartWith(String name){
//        List<BookEntity> listBook = bookRepository.getBookNameStartWith(name);
//        if(listBook.isEmpty()){
//            System.out.println("Book not exist");
//        }
//        for(BookEntity book : listBook){
//            System.out.println(book.toString());
//        }
//    }
//    private static void getBookWherePriceLessThanAndNumOfPageGreaterThan(double price, int numberPage) {
//        List<BookEntity> bookList = bookRepository. getBookWherePriceLessThanAndNumberOfPageGreaterThan(price, numberPage);
//        if (bookList.size() != 0) {
//            System.out.println("they are");
//            for (BookEntity book : bookList) {
//                System.out.println(book.toString());
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//       // createNewBook();
//        readBook();
//       // readBook(5);
//       // updateBook(3);
//       // deteleBook(2);
//       // findByAuthor("Alex");
//       // getBookNameStartWith("Tomy");
//       // getBookWherePriceLessThanAndNumOfPageGreaterThan(20.5,234);
    }


