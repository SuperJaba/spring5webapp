package pl.superjaba.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.superjaba.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
