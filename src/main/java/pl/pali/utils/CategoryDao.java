package pl.pali.utils;


import org.springframework.stereotype.Repository;
import pl.pali.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Category> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Category a");
        return query.getResultList();
    }
}
