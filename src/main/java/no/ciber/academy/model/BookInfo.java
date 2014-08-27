package no.ciber.academy.model;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.CacheRegionDefinition.CacheType;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;


    private String title;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    private String URL;
    private String ISBN;
    private String imageURL;
    private String edition;
    @Lob
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "copies")
    private Set<Book> copies = new HashSet<Book>();

    public BookInfo(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Set<Book> getCopies() {
		return copies;
	}

	public void setCopies(Set<Book> copies) {
		this.copies = copies;
	}



}
