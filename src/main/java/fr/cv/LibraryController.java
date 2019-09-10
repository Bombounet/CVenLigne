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
    m.addAttribute("users", userDAO.findAll());
    return "index";
  }

  @GetMapping("/contact")
  public String seeContact(Model m) {
    return "contact";
  }

  @PostMapping("/contact")
  public RedirectView closeContact() {
    return new RedirectView("/");
  }

  @GetMapping("/formations")
  public String seeFormations() {
    return "formations";
  }

  @PostMapping("/formations")
  public RedirectView quitFormations() {
    return new RedirectView("/");
  }

}
