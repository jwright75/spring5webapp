package domain;

import java.util.Set;

import javax.persistence.*;


@Entity
public class book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String isbn;
	
	@ManyToMany
	@JoinTable(name="author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<author> authors;
	
	
	
	public book() {
	}

	public book(String title, String isbn, Set<author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<author> authors) {
		this.authors = authors;
	}

	
}
