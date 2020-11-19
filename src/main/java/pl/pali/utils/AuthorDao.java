package pl.pali.utils;


import org.springframework.stereotype.Repository;
import pl.pali.entity.Article;
import pl.pali.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;


    public void add(Author author){
        entityManager.persist(author);
    }


    public Author read(Integer id){
        return entityManager.find(Author.class, id);
    }

    public void update (Author author){
        entityManager.merge(author);
    }

    public void delete(Integer id){
        entityManager.remove(read(id));
    }


    public List<Author> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }
}
