package no.ciber.academy.model.repository;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
}
