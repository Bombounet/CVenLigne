package fr.takima.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {

}
