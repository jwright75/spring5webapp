package jwright75.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fName;
	private String lName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
	

	public Author() {
	}

	public Author(String fName, String nName) {

		this.fName = fName;
		this.lName = nName;
	
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String nName) {
		this.lName = nName;
	}



	public Set<Book> getBooks() {
		return books;
	}



	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
	@Override
	public String toString() {
		return "author [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Author author = (Author) o;
		
		return id != null ? id.equals(author.id) : author.id == null;
		
		
	}

	
}
