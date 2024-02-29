package h.group.problemtracker.repository;

import h.group.problemtracker.model.Problem;
import h.group.problemtracker.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

}
