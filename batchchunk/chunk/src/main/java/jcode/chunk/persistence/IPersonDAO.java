package jcode.chunk.persistence;

import jcode.chunk.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person, Long> {
}
