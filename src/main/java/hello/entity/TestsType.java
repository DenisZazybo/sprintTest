package hello.entity;


import javax.persistence.*;
import java.util.Set;
@Entity
public class TestsType {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
