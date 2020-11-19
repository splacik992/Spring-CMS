package pl.pali.entity;


import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String title;

    @ManyToOne
    private Author author;

    @OneToMany
    private List<Category> categories = new ArrayList<>();

    private String content;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;


    @PrePersist
    public void prePersist(){
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updatedOn = LocalDateTime.now();
    }

}
