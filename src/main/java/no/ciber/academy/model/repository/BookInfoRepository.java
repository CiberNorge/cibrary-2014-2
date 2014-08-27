package no.ciber.academy.model.repository;

import no.ciber.academy.model.BookInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {
    List<BookInfo> findByTitle(String title);
    //BookInfo findByISBN(String ISBN);
}
