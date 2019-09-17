package fr.cv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 *
 */
@RequestMapping("/")
@Controller
public class LibraryController {

  private final UserDAO userDAO;

  public LibraryController(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @GetMapping
  public String homePage(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "see_index";
  }

  @GetMapping("/edit")
  public String editHomePage(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "edit_index";
  }

  @PostMapping("/edit/{id}")
  public RedirectView majHomePage(@ModelAttribute User user,@PathVariable String id, RedirectAttributes attrs) {
    //userDAO.changeInfoIndex(user);
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user1 = users.get(0);
    user1.setFirstName(user.getFirstName());
    user1.setLastName(user.getLastName());
    userDAO.save(user1);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/contact")
  public String contact(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "see_contact";
  }

  @GetMapping("/contact/edit")
  public String editContact(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "edit_contact";
  }

  @PostMapping("/contact/edit")
  public RedirectView majContact(@ModelAttribute User user, RedirectAttributes attrs) {
    //userDAO.changeInfoContact(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/formations")
  public String formations(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "see_formations";
  }

  @GetMapping("/formations/edit")
  public String editFormations(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "edit_formations";
  }

  @PostMapping("/formations/edit")
  public RedirectView majFormations(@ModelAttribute User user, RedirectAttributes attrs) {
    //userDAO.changeInfoFormations(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/experiences")
  public String experiences(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "see_experiences";
  }

  @GetMapping("/experiences/edit")
  public String editExperiences(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "edit_experiences";
  }

  @PostMapping("/experiences/edit")
  public RedirectView majExperiences(@ModelAttribute User user, RedirectAttributes attrs) {
    //userDAO.changeInfoExperiences(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/competences")
  public String competences(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "see_competences";
  }

  @GetMapping("/competences/edit")
  public String editCompetences(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
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
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "see_projets";
  }

  @GetMapping("/projets/edit")
  public String ediProjets(Model m) {
    long Id = 1;
    List <User> users  = (List<User>) userDAO.findAll();
    User user = users.get(0);
    m.addAttribute("user", user);
    return "edit_projets";
  }

  @PostMapping("/projets/edit")
  public RedirectView majProjets(@ModelAttribute User user, RedirectAttributes attrs) {
    //userDAO.changeInfoProjets(user);
    userDAO.save(user);
    return new RedirectView("/");
  }

}
