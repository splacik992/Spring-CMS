package pl.pali.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pali.entity.Article;
import pl.pali.entity.Author;
import pl.pali.entity.Category;
import pl.pali.utils.ArticleDao;
import pl.pali.utils.AuthorDao;
import pl.pali.utils.CategoryDao;

import javax.persistence.PrePersist;
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
    public String addArticle(Model model, @RequestParam String title,
                             @RequestParam String content, @RequestParam Category category,
                             @RequestParam Author author) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(category);
        article.setAuthor(author);
        articleDao.add(article);

        return "redirect:/";
    }


    @ModelAttribute("authors")
    public List<Author> getAllAuthor() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    List<Category> getAllCategory(){
        return categoryDao.findAll();
    }

}
