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
public class BookInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;


    private BookInstance bookInstance;

    private Book book;
    private List<Loan> bookLoans = new ArrayList<Loan>();

    public BookInstance(){

    }

    public BookInstance getBookInstance() {
        return bookInstance;
    }

    public void setBookInstance(BookInstance bookInstance) {
        this.bookInstance = bookInstance;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Loan> getBookLoans() {
        return bookLoans;
    }

    public void setBookLoans(List<Loan> bookLoans) {
        this.bookLoans = bookLoans;
    }
}
