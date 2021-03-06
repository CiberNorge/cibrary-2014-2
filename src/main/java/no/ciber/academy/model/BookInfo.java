package no.ciber.academy.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.CacheRegionDefinition.CacheType;
import org.hibernate.search.annotations.Boost;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
import javax.persistence.Table;


@Entity
@Table(name="BookInfo")
@Indexed
public class BookInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "You may not add books without a title. Please add a title")
    @Field
    @Boost(value = 1.5f)
    private String title;

    @NotEmpty(message = "You may not add a book without an author. Please add an author")
    @Field
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    @Column(length=2803)
    private String URL;

    @Field
    @Boost(value = 1.5f)
    private String ISBN;

    @NotEmpty(message = "You may not add a book without a imageURL. Please add a imageURL   ")
    @Column(length=2083)
    private String imageURL;
    private String edition;

    @Lob
    @Field
    @Boost(value = 1.5f)
    private String description;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn (name = "copies")
    private Set<Book> copies = new HashSet<Book>();
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> available = new HashSet<Book>();

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
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Book> getCopies() {
		return copies;
	}

	public void setCopies(Set<Book> copies) {
		this.copies = copies;
	}

	public Set<Book> getAvailable() {
		return available;
	}

	public void setAvailable(Set<Book> available) {
		this.available = available;
	}



}
