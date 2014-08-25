package no.ciber.academy.library;

import org.joda.time.LocalDateTime;

/**
 * Created by alegis on 25/08/14.
 */
public class Loan {

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
