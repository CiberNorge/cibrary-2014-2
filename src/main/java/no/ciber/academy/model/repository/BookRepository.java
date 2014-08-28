package no.ciber.academy.model.repository;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
