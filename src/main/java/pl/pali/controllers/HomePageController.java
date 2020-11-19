package pl.pali.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pali.entity.Article;
import pl.pali.utils.ArticleDao;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Article> articles = articleDao.findFiveLastArticles();
        model.addAttribute("articleList", articles);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("formaterDate",formatter);
        return "home";
    }
}
