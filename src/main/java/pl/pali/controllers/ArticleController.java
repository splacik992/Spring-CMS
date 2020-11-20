package pl.pali.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pali.entity.Article;
import pl.pali.entity.Author;
import pl.pali.entity.Category;
import pl.pali.utils.ArticleDao;
import pl.pali.utils.AuthorDao;
import pl.pali.utils.CategoryDao;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {


    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addArticleForm(Model model) {
        model.addAttribute("newArticle", new Article());
        return "article/newArticle";
    }

    @PrePersist
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/newArticle";
        } else {
            articleDao.add(article);
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Article updateArticle = articleDao.read(id);
        model.addAttribute("updateArticle", updateArticle);
        return "/article/updateArticle";
    }

    @PreUpdate
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateArticle(@PathVariable Integer id, Model model,
                                @RequestParam Author author, @RequestParam List<Category> category,
                                @RequestParam String content, @RequestParam String title) {
        Article article = articleDao.read(id);
        article.setAuthor(author);
        article.setCategory((List<Category>) category);
        article.setContent(content);
        article.setTitle(title);
        articleDao.update(article);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeArticle(@PathVariable Integer id) {
        articleDao.delete(id);
        return "redirect:/";
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthor() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    List<Category> getAllCategory() {
        return categoryDao.findAll();
    }

}
