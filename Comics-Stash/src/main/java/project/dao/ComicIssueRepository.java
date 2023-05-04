package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.ComicIssue;

public interface ComicIssueRepository extends JpaRepository<ComicIssue, Integer> {

    

}
