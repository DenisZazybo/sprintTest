package hello.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Answers {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String answers;
}
