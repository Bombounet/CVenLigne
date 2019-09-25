package fr.cv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLOutput;
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
    //System.out.println(getUser(1).getFormations().get(0).getName());
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

    List<Formation> formations = user.getFormations();

    //formations.get(0).setName("BLA");


    long ID = formations.size();
    Formation fo = new Formation(ID, "FO", "2020", "la", "blabla",user);
    formations.add(fo);

    user.setFormations(formations);


    userDAO.save(user);

    System.out.println("Formations dans le User: ");
    for(int i = 0 ; i < user.getFormations().size() ; i++){
      System.out.println(user.getFormations().get(i).getName());
    }
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

  @PostMapping("/formations/remove/{id}")
  public RedirectView removeFormations(@ModelAttribute User newData, @PathVariable (value="id") long id, RedirectAttributes attrs) {
    System.out.println("laaaaaaaaaa id = " + id);
    User user = userDAO.findById(id).get();
    System.out.println("Formations dans le User: ");
    for(int i = 0 ; i < user.getFormations().size() ; i++){
      System.out.println(user.getFormations().get(i).getName());
    }
    System.out.println("ID et nom de la formation qui vas etre Delete : " + id + " + " + user.getFormations().get((int)id - 1).getName());
    System.out.println();

    List<Formation> formations = user.getFormations();
    System.out.println("Creation list Formations = User.getFormation()");
    for(int i = 0 ; i < formations.size() ; i++){
      System.out.println(formations.get(i).getName());
    }System.out.println();

    formations.remove((int) id -1);
    System.out.println("Formation remove dans la list");
    for(int i = 0 ; i < formations.size() ; i++){
      System.out.println(formations.get(i).getName());
    }System.out.println();

    user.setFormations(formations);
    System.out.println("On met la liste dans le User : user.setFormations(formations);");
    for(int i = 0 ; i < user.getFormations().size() ; i++){
      System.out.println(user.getFormations().get(i).getName());
    }System.out.println();

    userDAO.save(user);
    System.out.println("Save du User : userDAO.save(user); - taille de user.getFormations().size() : " + user.getFormations().size());
    for(int i = 0 ; i < user.getFormations().size() ; i++){
      System.out.println(user.getFormations().get(i).getName());
    }System.out.println("FINNNNNNNNNNNNNNNNN de @PostMapping");System.out.println();

    return new RedirectView("/");
  }

  @GetMapping("/formations/edit/add")
  public String add(Model m) {
    User user = userDAO.findById(new Long(1)).get();
    int id = 1;
    long ID = id;
    Formation formation = new Formation( ID, "EPS", "2050" , "mtp", "BLOBLO ", user);
    user.getFormations().add(formation);
    for (int i = 0; i < user.getFormations().size() ; i++){
      System.out.println(user.getFormations().get(i).getName());
    }

    userDAO.save(user);

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
