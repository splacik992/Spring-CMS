package pl.pali.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.pali.entity.Category;
import pl.pali.utils.CategoryDao;

public class CategoryConverter implements Converter<String, Category> {


    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String s) {
        return categoryDao.read(Integer.valueOf(s));
    }
}
