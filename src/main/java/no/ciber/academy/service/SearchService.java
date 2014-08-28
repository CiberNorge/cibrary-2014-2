package no.ciber.academy.service;

import no.ciber.academy.model.BookInfo;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SearchService {

    @PersistenceContext
    private EntityManager em;



    @SuppressWarnings("unchecked")
    public List<BookInfo> search(String searchParameter){

        QueryBuilder qb = getFullTextEntityManager().getSearchFactory().buildQueryBuilder().forEntity(BookInfo.class).get();

        Query junction = qb.bool().must(qb.keyword()
                .onFields("title", "description", "ISBN", "author")
                .matching(searchParameter).createQuery())
                .createQuery();

        FullTextQuery fullTextQuery = getFullTextEntityManager().createFullTextQuery(junction, BookInfo.class);

        List<BookInfo> searchResult = (List<BookInfo>) fullTextQuery.getResultList();

        return searchResult;
    }

    private FullTextEntityManager getFullTextEntityManager() {
        return Search.getFullTextEntityManager(em);
    }


}
