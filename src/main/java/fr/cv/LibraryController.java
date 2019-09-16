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
    public String addUserPage(Model m) {
        m.addAttribute("user", userDAO.getUser());
        return "edit_index";
    }

    @PostMapping("/edit")
    public RedirectView createNewUser(@ModelAttribute User user, RedirectAttributes attrs) {
        userDAO.changeInfoIndex(user);
        return new RedirectView("/");
    }




/*
    @GetMapping("/edit")
    public String homePageEdit(Model m) {
        m.addAttribute("user", userDAO.getUser());
      System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "edit_index";
    }



  @PostMapping("/edit")
  public RedirectView homePageEditSaveInfo(@ModelAttribute User user, RedirectAttributes attrs) {
      attrs.addFlashAttribute("message", "Utilisateur ajouté avec succès");
        System.out.println("liiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
    userDAO.changeInfo(user);
    return new RedirectView("/");
  }*/




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

    @GetMapping("/experiences")
    public String seeExperiences() {
        return "experiences";
    }

    @PostMapping("/experiences")
    public RedirectView quitExperiences() {
        return new RedirectView("/");
    }

    @GetMapping("/competences")
    public String seeCompetences() {
        return "competences";
    }

    @PostMapping("/competences")
    public RedirectView quitCompetences() {
        return new RedirectView("/");
    }

    @GetMapping("/projets")
    public String seeProjets() {
        return "projets";
    }

    @PostMapping("/projets")
    public RedirectView quitProjet() {
        return new RedirectView("/");
    }

}
