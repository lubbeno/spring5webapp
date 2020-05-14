package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;


    private final BookRepository bookRepository;


    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher =new Publisher();
        publisher.setName("Martinus");
        publisher.setAddressLine1("BLava");
        publisher.setState("Slovakia");

        publisherRepository.save(publisher);
        Author eric =new Author("steven","eriksen");
        Book mkm = new Book("Malazka kniha padlych","111111111");
        eric.getBooks().add(mkm);
        mkm.getAuthors().add(eric);

        mkm.setPublisher(publisher);
        publisher.getBooks().add(mkm);

        authorRepository.save(eric);
        bookRepository.save(mkm);
        publisherRepository.save(publisher);


        System.out.println(bookRepository.count());


    }
}
