package hello.repos;
import hello.entity.Tests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestsRepository extends JpaRepository<Tests, Long> {
    //Tests findById(Long id);
}
