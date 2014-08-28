package no.ciber.academy.model;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.CacheRegionDefinition.CacheType;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class BookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String title;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    @Column(length=2803)
    private String URL;
    private String ISBN;

    @Column(length=2083)
    private String imageURL;
    private String edition;
    @Lob
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
