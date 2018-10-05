package pl.superjaba.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.superjaba.spring5webapp.model.Book;

@Component
public interface BookRepository extends CrudRepository<Book, Long> {
}
