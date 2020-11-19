package pl.pali.utils;


import org.springframework.stereotype.Repository;
import pl.pali.entity.Article;
import pl.pali.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void add(Category category) {
        entityManager.persist(category);
    }

    public Category read(Integer id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Integer id) {
        entityManager.remove(read(id));
    }


}
