package no.ciber.academy.library;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import no.ciber.academy.model.User;

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

    private User user;
    private Book book;
    private LocalDateTime timeOfCheckout;
    private LocalDateTime timeOfCheckin;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
