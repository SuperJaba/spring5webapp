package pl.superjaba.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.superjaba.spring5webapp.model.Author;
import pl.superjaba.spring5webapp.model.Book;
import pl.superjaba.spring5webapp.repositories.AuthorRepository;
import pl.superjaba.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author author = new Author("Jhon", "Rambo");
        Book book = new Book("Unicorn", "15643", "Znak.pl");
        book.getAuthors().add(author);
        author.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);

        Author author1 = new Author("Jacek", "Kononiwicz");
        Book book1 = new Book("Zaszyty komplex", "4897", "Inex");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author aut = new Author("Sebix", "Czar");
        Book boo = new Book("Nirwana", "2019", "Aniol");
        aut.getBooks().add(boo);
        boo.getAuthors().add(aut);
        boo.getAuthors().add(new Author("Archaniol", "Michal"));

        authorRepository.save(aut);
        bookRepository.save(boo);
    }
}
