package fr.cv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.*;
import java.util.List;



/**
 *
 */
@RequestMapping("/")
@Controller
public class LibraryController {

  private static UserDAO userDAO;
  //public static String url = "jdbc:mariadb://192.168.99.100/defaultdb";
  public static String url = "jdbc:mariadb://localhost/defaultdb";

  public LibraryController(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @GetMapping
  public String homePage(Model m) {
    m.addAttribute("user", getUser(1));
    System.out.println(getUser(1).getFormations().get(0).getName());
    return "see_index";
  }

  @GetMapping("/edit")
  public String editHomePage(Model m) {
    m.addAttribute("user", getUser(1));
    return "edit_index";
  }

  @PostMapping("/edit/{id}")
  public RedirectView majHomePage(@ModelAttribute User newData, @PathVariable String id, RedirectAttributes attrs) {
    User user = getUser(1);
    user.setFirstName(newData.getFirstName());
    user.setLastName(newData.getLastName());
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/contact")
  public String contact(Model m) {
    m.addAttribute("user", getUser(1));
    return "see_contact";
  }

  @GetMapping("/contact/edit")
  public String editContact(Model m) {
    m.addAttribute("user", getUser(1));
    return "edit_contact";
  }

  @PostMapping("/contact/edit/{id}")
  public RedirectView majContact(@ModelAttribute User newData, @PathVariable String id, RedirectAttributes attrs) {
    User user = getUser(1);
    user.setContact(newData.getContact());
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/formations")
  public String formations(Model m) {
    m.addAttribute("user", getUser(1));
    return "see_formations";
  }

  @GetMapping("/formations/edit")
  public String editFormations(Model m) {
    m.addAttribute("user", getUser(1));
    m.addAttribute("formations", getFormations(1));
    return "edit_formations";
  }

 /* @PostMapping("/formations/edit/{id}")
  public RedirectView majFormations(@ModelAttribute User newData, @PathVariable String id, RedirectAttributes attrs) {
    User user = getUser(1);
    userDAO.save(user);
    return new RedirectView("/");
  }

  @PostMapping("/formations/edit/{id}")
  public RedirectView editFormations(@ModelAttribute User newData, @PathVariable String id, RedirectAttributes attrs) {
    User user = getUser(1);
    userDAO.save(user);
    return new RedirectView("/");
  }*/

  @PostMapping("/formations/edit/remove/{id}")
  public RedirectView removeFormations(@ModelAttribute User newData, @PathVariable(value = "id") long idlong, RedirectAttributes attrs) throws SQLException {


    Connection conn = DriverManager.getConnection(url, "root", "toor");
    // create a Statement from the connection
    Statement statement = conn.createStatement();
    // insert the data
    statement.executeUpdate("delete from formations where id = " + idlong);
    System.out.println("laaaa");
    return new RedirectView("/formations/edit");
  }

  @GetMapping("/formations/edit/add")
  public RedirectView addFormations(RedirectAttributes attrs) throws SQLException {


    Connection conn = DriverManager.getConnection(url, "root", "toor");
    // create a Statement from the connection
    Statement statement = conn.createStatement();
    // insert the data
    statement.executeUpdate("INSERT INTO formations " + "VALUES (ID, ' ' , ' '  , ' '  ,  ' ' , 1)");
    return new RedirectView("/formations/edit");
  }


  @GetMapping("/formations/add/{id}")
  public String editOneFormation(Model m, @PathVariable(value = "id") long idlong) {
    m.addAttribute("user", getUser(1));
    m.addAttribute("formation_competence_experience", getFormation(1, idlong));
    m.addAttribute("type", "formations");
    return "add_formation_competence_experience";
  }

  @PostMapping("/formations/add/{id}")
  public RedirectView majFormation(@ModelAttribute Formation newData, @PathVariable(value = "id") long idlong, RedirectAttributes attrs) {
    List<Formation> formations = getFormations(1);
    formations.get((int) idlong - 1).setName(newData.getName());
    formations.get((int) idlong - 1).setPlace(newData.getPlace());
    formations.get((int) idlong - 1).setYear(newData.getYear());
    formations.get((int) idlong - 1).setDescription(newData.getDescription());
    User user = getUser(1);
    user.setFormations(formations);
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/experiences")
  public String experiences(Model m) {
    m.addAttribute("user", getUser(1));
    return "see_experiences";
  }

  @GetMapping("/experiences/edit")
  public String editExperiences(Model m) {
    m.addAttribute("user", getUser(1));
    m.addAttribute("experiences", getExperiences(1));
    return "edit_experiences";
  }


  @GetMapping("/experiences/edit/add")
  public RedirectView addExperience(RedirectAttributes attrs) throws SQLException {


    Connection conn = DriverManager.getConnection(url, "root", "toor");
    // create a Statement from the connection
    Statement statement = conn.createStatement();
    // insert the data
    statement.executeUpdate("INSERT INTO experiences " + "VALUES (ID, ' ' , ' '  , ' '  ,  ' ' , 1)");
    return new RedirectView("/experiences/edit");
  }

  @PostMapping("/experiences/edit/remove/{id}")
  public RedirectView removeExperiences(@ModelAttribute User newData, @PathVariable(value = "id") long idlong, RedirectAttributes attrs) throws SQLException {
      Connection conn = DriverManager.getConnection(url, "root", "toor");
      Statement statement = conn.createStatement();
      statement.executeUpdate("delete from experiences where id = " + idlong);
      System.out.println("laaaa");
      return new RedirectView("/experiences/edit");
    }


    @GetMapping("/experiences/add/{id}")
    public String editOneexperience (Model m,@PathVariable(value = "id") long idlong){
      m.addAttribute("user", getUser(1));
      m.addAttribute("formation_competence_experience", getExperience(1, idlong));
      m.addAttribute("type", "experiences");
      return "add_formation_competence_experience";
    }

    @PostMapping("/experiences/add/{id}")
    public RedirectView majExperience (@ModelAttribute Formation newData,
    @PathVariable(value = "id") long idlong, RedirectAttributes attrs){
      List<Experience> experiences = getExperiences(1);
      experiences.get((int) idlong - 1).setName(newData.getName());
      experiences.get((int) idlong - 1).setPlace(newData.getPlace());
      experiences.get((int) idlong - 1).setYear(newData.getYear());
      experiences.get((int) idlong - 1).setDescription(newData.getDescription());
      User user = getUser(1);
      user.setExperiences(experiences);
      userDAO.save(user);
      return new RedirectView("/");
    }
    /*------------------------------------------------------------------------------*/

    @GetMapping("/competences")
    public String competences (Model m){
      m.addAttribute("user", getUser(1));
      return "see_competences";
    }

    @GetMapping("/competences/edit")
    public String editCompetences (Model m){
      m.addAttribute("user", getUser(1));
      m.addAttribute("competences", getCompetences(1));
      return "edit_competences";
    }

    @PostMapping("/competences/edit/remove/{id}")
    public RedirectView removeCompetence (@ModelAttribute User newData,
    @PathVariable(value = "id") long idlong, RedirectAttributes attrs) throws SQLException {


      Connection conn = DriverManager.getConnection(url, "root", "toor");
      // create a Statement from the connection
      Statement statement = conn.createStatement();
      // insert the data
      statement.executeUpdate("delete from competences where id = " + idlong);
      System.out.println("laaaa");
      return new RedirectView("/competences/edit");
    }

    @GetMapping("/competences/edit/add")
    public RedirectView addCompetence (RedirectAttributes attrs) throws SQLException {


      Connection conn = DriverManager.getConnection(url, "root", "toor");
      // create a Statement from the connection
      Statement statement = conn.createStatement();
      // insert the data
      statement.executeUpdate("INSERT INTO competences " + "VALUES (ID, ' ' , 1)");
      System.out.println("laaaa");
      return new RedirectView("/competences/edit");
    }


    @GetMapping("/competences/add/{id}")
    public String editOneCompetence (Model m,@PathVariable(value = "id") long idlong){
      System.out.println("laaaa4");
      m.addAttribute("user", getUser(1));
      m.addAttribute("competence", getCompetence(1, idlong));
      return "add_competence";
    }

    @PostMapping("/competences/add/{id}")
    public RedirectView majCompetence (@ModelAttribute Competence newData,
    @PathVariable(value = "id") long idlong, RedirectAttributes attrs){
      List<Competence> competences = getCompetences(1);
      System.out.println(newData.getName());
      competences.get((int) idlong - 1).setName(newData.getName());
      User user = getUser(1);
      user.setCompetences(competences);
      userDAO.save(user);
      return new RedirectView("/");
    }


    /*------------------------------------------------------------------------------*/

    @GetMapping("/projets")
    public String projets (Model m){
      m.addAttribute("user", getUser(1));
      return "see_projets";
    }

    @GetMapping("/projets/edit")
    public String ediProjets (Model m){
      m.addAttribute("user", getUser(1));
      m.addAttribute("projets", getProjets(1));
      return "edit_projets";
    }


    @GetMapping("/projets/edit/add")
    public RedirectView addProjets (RedirectAttributes attrs) throws SQLException {


      Connection conn = DriverManager.getConnection(url, "root", "toor");
      // create a Statement from the connection
      Statement statement = conn.createStatement();
      // insert the data
      statement.executeUpdate("INSERT INTO projets " + "VALUES (ID, ' ' , ' '  , ' '  ,  ' ' , 1)");
      return new RedirectView("/projets/edit");
    }

    @PostMapping("/projets/edit/remove/{id}")
    public RedirectView removeProjets (@ModelAttribute User newData,
    @PathVariable(value = "id") long idlong, RedirectAttributes attrs) throws SQLException {
      Connection conn = DriverManager.getConnection(url, "root", "toor");
      Statement statement = conn.createStatement();
      statement.executeUpdate("delete from projets where id = " + idlong);
      System.out.println("laaaa");
      return new RedirectView("/projets/edit");
    }

    @GetMapping("/projets/add/{id}")
    public String editOneProjet (Model m,@PathVariable(value = "id") long idlong){
      System.out.println("laaaa4");
      m.addAttribute("user", getUser(1));
      m.addAttribute("formation_competence_experience", getProjet(1, idlong));
      m.addAttribute("type", "projets");
      return "add_formation_competence_experience";
    }

    @PostMapping("/projets/add/{id}")
    public RedirectView majProjet (@ModelAttribute Formation newData,
    @PathVariable(value = "id") long idlong, RedirectAttributes attrs){
      List<Projet> projets = getProjets(1);
      projets.get((int) idlong - 1).setName(newData.getName());
      projets.get((int) idlong - 1).setPlace(newData.getPlace());
      projets.get((int) idlong - 1).setYear(newData.getYear());
      projets.get((int) idlong - 1).setDescription(newData.getDescription());
      User user = getUser(1);
      user.setProjets(projets);
      userDAO.save(user);
      return new RedirectView("/");
    }


    public static User getUser ( long Id){
      List<User> users = (List<User>) userDAO.findAll();
      User user = users.get((int) Id - 1);
      return user;
    }

    public static List<Formation> getFormations ( long Id){
      User user = getUser(Id);
      List<Formation> formations = user.getFormations();
      return formations;
    }


    public static List<Projet> getProjets ( long Id){
      User user = getUser(Id);
      List<Projet> projets = user.getProjets();
      return projets;
    }

    public static List<Experience> getExperiences ( long Id){
      User user = getUser(Id);
      List<Experience> experiences = user.getExperiences();
      return experiences;
    }

    public static List<Competence> getCompetences ( long Id){
      User user = getUser(Id);
      List<Competence> competences = user.getCompetences();
      return competences;
    }

    public static Formation getFormation ( long Id, long ID){
      List<Formation> formations = getFormations(Id);
      Formation formation = formations.get((int) ID - 1);
      return formation;
    }

    public static Experience getExperience ( long Id, long ID){
      List<Experience> experiences = getExperiences(Id);
      Experience experience = experiences.get((int) ID - 1);
      return experience;
    }

    public static Projet getProjet ( long Id, long ID){
      List<Projet> projets = getProjets(Id);
      Projet projet = projets.get((int) ID - 1);
      return projet;
    }

    public static Competence getCompetence ( long Id, long ID){
      List<Competence> competences = getCompetences(Id);
      Competence competence = competences.get((int) ID - 1);
      return competence;
  }
  }
