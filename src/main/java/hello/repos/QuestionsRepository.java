package hello.repos;

import hello.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    //Tests findById(Long id);
}
