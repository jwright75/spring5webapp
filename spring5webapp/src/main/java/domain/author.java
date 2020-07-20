package domain;

import java.util.Set;

import javax.persistence.*;


@Entity
public class author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fName;
	private String nName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<book> books;
	
	//help

	public author() {
	}

	public author(String fName, String nName, Set<book> books) {

		this.fName = fName;
		this.nName = nName;
		this.books = books;
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



	public String getnName() {
		return nName;
	}



	public void setnName(String nName) {
		this.nName = nName;
	}



	public Set<book> getBooks() {
		return books;
	}



	public void setBooks(Set<book> books) {
		this.books = books;
	}

	
}
