package pl.pali.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pali.entity.Author;
import pl.pali.utils.AuthorDao;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAuthorList(Model model) {
        model.addAttribute("allAuthors", authorDao.findAll());
        return "author/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newAuthorForm(Model model) {
        model.addAttribute("newAuthor", new Author());
        return "author/addAuthor";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newAuthor(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/author/addAuthor";
        } else {
            authorDao.add(author);
        }
        return "redirect: /author/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(Model model, @PathVariable Integer id) {
        Author read = authorDao.read(id);
        model.addAttribute("showAuthor", read);
        return "author/updateAuthor";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateAuthor(@PathVariable Integer id, @RequestParam String firstName,
                               @RequestParam String lastName) {

        Author author = authorDao.read(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return "redirect: /author/all";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable Integer id) {
        authorDao.delete(id);
        return "redirect: /author/all";
    }

}
