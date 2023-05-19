package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookbetails")
public class BookDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private int price;
    private int numberofPage;
    private LocalDate publishDate;

    public BookDetailsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberofPage() {
        return numberofPage;
    }

    public void setNumberofPage(int numberofPage) {
        this.numberofPage = numberofPage;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "BookDetailsEntity{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", numberofPage=" + numberofPage +
                ", publishDate=" + publishDate +
                '}';
    }
}
