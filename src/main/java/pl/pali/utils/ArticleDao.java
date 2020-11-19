package pl.pali.utils;


import org.springframework.stereotype.Repository;
import pl.pali.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void add(Article article) {
        entityManager.persist(article);
    }

    public Article read(Integer id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Integer id) {
        entityManager.remove(read(id));
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

}
