package no.ciber.academy.library;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alegis on 25/08/14.
 *
 * TODO: This is by no means complete. What fields are needed, for instance?
 */
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;


    private Book book;

    private BookInfo bookInfo;
    private List<Loan> bookLoans = new ArrayList<Loan>();

    public Book(){

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public List<Loan> getBookLoans() {
        return bookLoans;
    }

    public void setBookLoans(List<Loan> bookLoans) {
        this.bookLoans = bookLoans;
    }
}
