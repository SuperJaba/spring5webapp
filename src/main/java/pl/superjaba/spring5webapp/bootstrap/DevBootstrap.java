package pl.superjaba.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.superjaba.spring5webapp.model.Author;
import pl.superjaba.spring5webapp.model.Book;
import pl.superjaba.spring5webapp.model.Publisher;
import pl.superjaba.spring5webapp.repositories.AuthorRepository;
import pl.superjaba.spring5webapp.repositories.BookRepository;
import pl.superjaba.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher pub0 = new Publisher("Znak", "ul. Półwiejska 15 Poznań");
        publisherRepository.save(pub0);

        Author author = new Author("Jhon", "Rambo");
        Book book = new Book("Unicorn", "15643");

        book.setPublisher(pub0);
        book.getAuthors().add(author);
        author.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);

        Publisher pub1 = new Publisher("Inex", "Tu i tam, Owocno");
        publisherRepository.save(pub1);
        Author author1 = new Author("Jacek", "Kononiwicz");
        Book book1 = new Book("Zaszyty komplex", "4897", pub1);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);
//

        Publisher pub2 = new Publisher("Aniolex", "Niebo, Za brama");
        publisherRepository.save(pub2);
        Author aut = new Author("Sebix", "Czar");
        Book boo = new Book("Nirwana", "2019", pub2);
        aut.getBooks().add(boo);
        boo.getAuthors().add(aut);
        boo.getAuthors().add(new Author("Archaniol", "Michal"));

        authorRepository.save(aut);
        bookRepository.save(boo);
    }
}
