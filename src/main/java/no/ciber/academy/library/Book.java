package no.ciber.academy.library;
import org.joda.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by alegis on 25/08/14.
 *
 * TODO: This is not complete. The fields for a book needs to be decided
 *
 * This class is meant to work as a definition of what a book is and to determine the name, author etc of a book.
 * Since a book can have more than one instance.
 */
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;


    private String bookName;
    private String author;
    private LocalDate releaseDate;
    private String webLink;
    private long ISBN;
    //TODO: Field for which office owns the book?

    public Book(){

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }


    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
