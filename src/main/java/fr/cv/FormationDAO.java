package fr.cv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationDAO extends CrudRepository<User, Long> {
}