package hello.entity;


import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Questions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String questions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_test")
    private Tests test;
}
