package pl.pali.utils;


import org.springframework.stereotype.Repository;
import pl.pali.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
}
