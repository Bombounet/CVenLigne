package fr.cv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.*;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@RequestMapping("/")
@Controller
public class LibraryController {

  private static UserDAO userDAO;

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
  public RedirectView removeFormations(@ModelAttribute User newData, @PathVariable (value="id") long id, RedirectAttributes attrs) throws SQLException {

    String url = "jdbc:mariadb://localhost/defaultdb";
    Connection conn = DriverManager.getConnection(url,"root","toor");
    // create a Statement from the connection
    Statement statement = conn.createStatement();
    // insert the data
    statement.executeUpdate("delete from formations where id = 1");
    System.out.println("laaaa");
    return new RedirectView("/");
  }

  @GetMapping("/formations/edit/add")
  public String add(Model m) throws SQLException {
    User user = userDAO.findById(new Long(1)).get();
    int id = 3;
    long ID = id;
    //Formation formation = new Formation( ID, "EPS", "2050" , "mtp", "BLOBLO ", user);
    //user.getFormations().add(formation);

    for (int i = 0; i < user.getFormations().size() ; i++){
      System.out.println(user.getFormations().get(i).getName());
    }
    String url = "jdbc:mariadb://localhost/defaultdb";
    Connection conn = DriverManager.getConnection(url,"root","toor");
    // create a Statement from the connection
    Statement statement = conn.createStatement();
    // insert the data
    statement.executeUpdate("INSERT INTO formations " + "VALUES (ID, 'EPS', '2050', 'mtp', 'balbval', 1)");


    userDAO.save(user);
    System.out.println("laaaa2");
    return "add";
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
    return "edit_experiences";
  }

  @PostMapping("/experiences/edit/{id}")
  public RedirectView majExperiences(@ModelAttribute User user, @PathVariable String id, RedirectAttributes attrs) {
    //userDAO.changeInfoExperiences(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/competences")
  public String competences(Model m) {
    m.addAttribute("user", getUser(1));
    return "see_competences";
  }

  @GetMapping("/competences/edit")
  public String editCompetences(Model m) {
    m.addAttribute("user", getUser(1));
    return "edit_competences";
  }

  @PostMapping("/competences/edit/{id}")
  public RedirectView majCompetences(@ModelAttribute User user,@PathVariable String id, RedirectAttributes attrs) {
    //userDAO.changeInfoCompetences(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/projets")
  public String projets(Model m) {
    m.addAttribute("user", getUser(1));
    return "see_projets";
  }

  @GetMapping("/projets/edit")
  public String ediProjets(Model m) {
    m.addAttribute("user", getUser(1));
    return "edit_projets";
  }

  @PostMapping("/projets/edit/{id}")
  public RedirectView majProjets(@ModelAttribute User user, @PathVariable String id, RedirectAttributes attrs) {
    //userDAO.changeInfoProjets(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

  public static User getUser(long Id){
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get((int)Id-1);
    return user;
  }

  public static List<Formation> getFormations(long Id){
    User user = getUser(Id);
    List<Formation> formations = user.getFormations();
    return formations;
  }


}
