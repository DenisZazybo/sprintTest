package hello.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Tests {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    // private String questions;
    private TestsType type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestsType getType() {
        return type;
    }

    public void setType(TestsType type) {
        this.type = type;
    }

}
