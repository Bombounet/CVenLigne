package fr.cv;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
@Repository
public class UserDAO {
  private List<User> users = new ArrayList<>();

  public void add(User u) {
    users.add(u);
  }

  public List<User> findAll() {
    return Collections.unmodifiableList(users);
  }

  public User getUser(){ return users.get(0);}

  @PostConstruct
  public void initDb() {

    List<Experience> experiences = new ArrayList<>();
    List<Formation> formations = new ArrayList<>();
    List<Projet> projets = new ArrayList<>();
    List<String> competences = new ArrayList<>();
    experiences.add(new Experience("Space engineer","2015-2020","NASA","i went to mars (2 times)"));
    formations.add(new Formation("ENS Cachan", "2014", "Cachan","major student"));
    projets.add(new Projet("Jeu en Java","2017","Montpellier EPF","we code a modified version of binding of Isaac named Binding of the PEUF, we code more than 3 days in a row"));
    competences.add("Anglais F1");
    competences.add("Espagnol F1");
    competences.add("Suite office");
    competences.add("Catia");
    competences.add("Java");
    competences.add("C");
    competences.add("IA");
    users.add(new User(1,"Loïc", "Ortola", 8, 10,1997, "toto@hotmail.com" ,
            new Adresse("21 rue de la porte du passée","viennes",34250,"FRANCE") ,610798624 ,
             experiences,  formations,projets,competences ));
  }
}
