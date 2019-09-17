package fr.cv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {


}


  public void changeInfoIndex(User newUser) {
    users.get(0).setFirstName(newUser.getFirstName());
    users.get(0).setLastName(newUser.getLastName());
  }

  public void changeInfoContact(User newUser) {
    users.get(0).setFirstName(newUser.getFirstName());
    users.get(0).setLastName(newUser.getLastName());
  }

  public void changeInfoFormations(User newUser) {
    users.get(0).setFirstName(newUser.getFirstName());
    users.get(0).setLastName(newUser.getLastName());
  }

  public void changeInfoExperiences(User newUser) {
    users.get(0).setFirstName(newUser.getFirstName());
    users.get(0).setLastName(newUser.getLastName());
  }

  public void changeInfoCompetences(User newUser) {
    users.get(0).setFirstName(newUser.getFirstName());
    users.get(0).setLastName(newUser.getLastName());
  }

  public void changeInfoProjets(User newUser) {
    users.get(0).setFirstName(newUser.getFirstName());
    users.get(0).setLastName(newUser.getLastName());
  }

}
