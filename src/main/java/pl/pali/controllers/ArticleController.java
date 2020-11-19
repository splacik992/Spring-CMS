package pl.pali.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pali.entity.Article;
import pl.pali.entity.Author;
import pl.pali.utils.ArticleDao;
import pl.pali.utils.AuthorDao;

import javax.persistence.PrePersist;

@Controller
@RequestMapping("/article")
public class ArticleController {


    private final ArticleDao articleDao;
    private final AuthorDao authorDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
    }

    @PrePersist
    @RequestMapping(value = "/addd", method = RequestMethod.GET)
    public String addArticle(Model model){
        Article article = new Article();
        Author author = authorDao.read(1);
        article.setAuthor(author);
        article.setTitle("O Warszawo");
        article.setContent("Historia Warszawyłł");
        articleDao.add(article);
        model.addAttribute("newArticle",article);
        return "newArticle";
    }
}