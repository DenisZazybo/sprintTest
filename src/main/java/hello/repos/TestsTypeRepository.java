package hello.repos;


import hello.entity.TestsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestsTypeRepository extends JpaRepository<TestsType, Long> {

}
