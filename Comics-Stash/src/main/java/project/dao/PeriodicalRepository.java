package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.Periodical;

public interface PeriodicalRepository extends JpaRepository<Periodical, Integer> {

}
