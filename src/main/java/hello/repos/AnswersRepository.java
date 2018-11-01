package hello.repos;

import hello.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers, Long> {
    //Tests findById(Long id);
}
