package fr.cv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    m.addAttribute("user", userDAO.getUser());
    return "see_index";
  }

  @GetMapping("/edit")
  public String editHomePage(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "edit_index";
  }

  @PostMapping("/edit")
  public RedirectView majHomePage(@ModelAttribute User user, RedirectAttributes attrs) {
    userDAO.changeInfoIndex(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/contact")
  public String contact(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "see_contact";
  }

  @GetMapping("/contact/edit")
  public String editContact(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "edit_contact";
  }

  @PostMapping("/contact/edit")
  public RedirectView majContact(@ModelAttribute User user, RedirectAttributes attrs) {
    userDAO.changeInfoContact(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/formations")
  public String formations(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "see_formations";
  }

  @GetMapping("/formations/edit")
  public String editFormations(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "edit_formations";
  }

  @PostMapping("/formations/edit")
  public RedirectView majFormations(@ModelAttribute User user, RedirectAttributes attrs) {
    userDAO.changeInfoFormations(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/experiences")
  public String experiences(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "see_experiences";
  }

  @GetMapping("/experiences/edit")
  public String editExperiences(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "edit_experiences";
  }

  @PostMapping("/experiences/edit")
  public RedirectView majExperiences(@ModelAttribute User user, RedirectAttributes attrs) {
    userDAO.changeInfoExperiences(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/competences")
  public String competences(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "see_competences";
  }

  @GetMapping("/competences/edit")
  public String editCompetences(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "edit_competences";
  }

  @PostMapping("/competences/edit")
  public RedirectView majCompetences(@ModelAttribute User user, RedirectAttributes attrs) {
    userDAO.changeInfoCompetences(user);
    return new RedirectView("/");
  }

  /*------------------------------------------------------------------------------*/

  @GetMapping("/projets")
  public String projets(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "see_projets";
  }

  @GetMapping("/projets/edit")
  public String ediProjets(Model m) {
    m.addAttribute("user", userDAO.getUser());
    return "edit_projets";
  }

  @PostMapping("/projets/edit")
  public RedirectView majProjets(@ModelAttribute User user, RedirectAttributes attrs) {
    userDAO.changeInfoProjets(user);
    return new RedirectView("/");
  }

}
