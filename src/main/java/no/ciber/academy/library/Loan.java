package no.ciber.academy.library;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.joda.time.LocalDateTime;

/**
 * Created by alegis on 25/08/14.
 *
 * TODO: This is not complete. This is a definition of what a loan is.
 */
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private BookLoaner bookLoaner;
    private BookInstance bookInstance;
    private LocalDateTime timeOfCheckout;
    private LocalDateTime timeOfCheckin;


    public BookLoaner getBookLoaner() {
        return bookLoaner;
    }

    public void setBookLoaner(BookLoaner bookLoaner) {
        this.bookLoaner = bookLoaner;
    }

    public BookInstance getBookInstance() {
        return bookInstance;
    }

    public void setBookInstance(BookInstance bookInstance) {
        this.bookInstance = bookInstance;
    }

    public LocalDateTime getTimeOfCheckout() {
        return timeOfCheckout;
    }

    public void setTimeOfCheckout(LocalDateTime timeOfCheckout) {
        this.timeOfCheckout = timeOfCheckout;
    }

    public LocalDateTime getTimeOfCheckin() {
        return timeOfCheckin;
    }

    public void setTimeOfCheckin(LocalDateTime timeOfCheckin) {
        this.timeOfCheckin = timeOfCheckin;
    }
}
