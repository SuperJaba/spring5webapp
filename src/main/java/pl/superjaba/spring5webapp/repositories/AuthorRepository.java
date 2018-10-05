package pl.superjaba.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.superjaba.spring5webapp.model.Author;

@Component
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
