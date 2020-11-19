package pl.pali.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pali.entity.Category;
import pl.pali.utils.CategoryDao;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String showAllCategories(Model model){
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categoriesList", categories);
        return "category/all";
    }




    @RequestMapping(value = "/add", method = RequestMethod.GET)

    public String showCategoryForm(Model model){
        model.addAttribute("newCategory",new Category());
        return "category/addNew";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewCategory(@RequestParam String name, @RequestParam String description){
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryDao.add(category);
        return "redirect: /category/all";
    }


    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateCategoryForm(Model model, @PathVariable String id){
        Category read = categoryDao.read(Integer.valueOf(id));
        model.addAttribute("updateCategory",read);
        return "category/updateCategory";
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String updateFormCategory(@PathVariable Integer id,
                                     @RequestParam String name, @RequestParam String description){
        Category category = categoryDao.read(id);
        category.setName(name);
        category.setDescription(description);
        categoryDao.update(category);
        return "redirect: /category/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(Model model,@PathVariable String id){

        categoryDao.delete(Integer.valueOf(id));

        return "redirect: /category/all";
    }
}
