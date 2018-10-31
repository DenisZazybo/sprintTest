package hello.entity;


import javax.persistence.*;
import java.util.Set;
@Entity
public class TestsType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String type;
}
