package no.ciber.academy.library;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by alegis on 25/08/14.
 *
 * TODO: This is not complete. The class is meant to be a definiton of what a person loaning a book is.
 */
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;



}
