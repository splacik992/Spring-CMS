package pl.pali.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.pali.entity.Author;
import pl.pali.utils.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return authorDao.read(Integer.parseInt(source));
    }

}