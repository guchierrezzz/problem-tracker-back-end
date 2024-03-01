package h.group.problemtracker.service.impl;

import h.group.problemtracker.dto.ProblemDTO;
import h.group.problemtracker.exception.AppException;
import h.group.problemtracker.model.Problem;
import h.group.problemtracker.model.Project;
import h.group.problemtracker.repository.ProblemRepository;
import h.group.problemtracker.repository.ProjectRepository;
import h.group.problemtracker.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProblemServiceImpl implements ProblemService {
    private final ProblemRepository problemRepository;
    private final ProjectRepository projectRepository;

    public ProblemServiceImpl(ProblemRepository problemRepository, ProjectRepository projectRepository) {
        this.problemRepository = problemRepository;
        this.projectRepository = projectRepository;
    }

    public Problem createProblem(final ProblemDTO problemData, final long projectId) {
        final Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new AppException("Project not found", HttpStatus.NOT_FOUND));

        Problem newProblem = new Problem(foundProject, problemData.getTitle(), problemData.getDescription(), problemData.isFinished(), problemData.getStarted_at(), problemData.getStarting_value(), problemData.getGoal_value(), problemData.getPotential_profit());
        return problemRepository.save(newProblem);
    }

    public List<Problem> readProblems(final long projectId) {
        final Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new AppException("Project not found", HttpStatus.NOT_FOUND));

        List<Problem> problems = problemRepository.findAll();

        return problems.stream()
                .filter(problem -> problem.getProject().equals(foundProject))
                .collect(Collectors.toList());
    }

    public Problem updateProblem(ProblemDTO problemData, final long projectId, final long problemId) {
        final Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new AppException("Project not found", HttpStatus.NOT_FOUND));
        final Problem foundProblem = problemRepository.findById(problemId).orElseThrow(() -> new AppException("Problem not found", HttpStatus.NOT_FOUND));

        foundProblem.setFinished(problemData.isFinished());

        return problemRepository.save(foundProblem);
    }

    public void deleteProblem(final long projectId, final long problemId) {
        final Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new AppException("Project not found", HttpStatus.NOT_FOUND));
        final Problem foundProblem = problemRepository.findById(problemId).orElseThrow(() -> new AppException("Problem not found", HttpStatus.NOT_FOUND));
        problemRepository.delete(foundProblem);
    }
}
