package jwright75.springframework.spring5webapp.bootstrap;

import jwright75.springframework.spring5webapp.domain.Publisher;
import jwright75.springframework.spring5webapp.domain.Author;
import jwright75.springframework.spring5webapp.domain.Book;
import jwright75.springframework.spring5webapp.repositories.AuthorRepository;
import jwright75.springframework.spring5webapp.repositories.BookRepository;
import jwright75.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public bootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("started in bootstrap");
		
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("st petersburg");
		publisher.setState("FL");
		
		publisherRepository.save(publisher);
		
		System.out.println("Pub Count:" + publisherRepository.count());
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book( "Domain Driven Design", "123123");
		
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23423566");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("pub num of books:" + publisher.getBooks().size());
		
	}
}
