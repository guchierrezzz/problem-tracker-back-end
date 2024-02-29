package h.group.problemtracker.service;

import h.group.problemtracker.dto.ProblemDTO;
import h.group.problemtracker.model.Problem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemService {

    Problem createProblem(final ProblemDTO problemData, final long projectId);
    List<Problem> readProblems(final long projectId) ;
    Problem updateProblem(ProblemDTO problemData, final long projectId, final long problemId);
    void deleteProblem(final long projectId, final long problemId);

}
