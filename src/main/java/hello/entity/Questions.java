package hello.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Questions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    private String ques;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_test")
    private Tests test;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Answers> answers = new HashSet<Answers>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tests getTest() {
        return test;
    }

    public void setTest(Tests test) {
        this.test = test;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }


}
