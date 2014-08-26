package no.ciber.academy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alegis on 25/08/14.
 */

@Controller
public class BookController {

    @RequestMapping("/books")
    public String books() {
        return "books";
    }


    //TODO: Add books
    //TODO: Delete books


}
