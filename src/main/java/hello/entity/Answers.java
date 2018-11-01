package hello.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Answers {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String answers;


    private boolean trues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_question")
    private Questions question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public boolean isTrues() {
        return trues;
    }

    public void setTrues(boolean trues) {
        this.trues = trues;
    }
}
