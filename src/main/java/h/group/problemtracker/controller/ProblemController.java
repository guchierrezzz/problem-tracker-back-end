package h.group.problemtracker.controller;

import h.group.problemtracker.dto.ProblemDTO;
import h.group.problemtracker.model.Problem;
import h.group.problemtracker.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/{projectId}/problem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProblemController {
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping
    public ResponseEntity<Problem> createProblem(@Valid @RequestBody final ProblemDTO problemData, @PathVariable long projectId) {
        final Problem createdProblem = problemService.createProblem(problemData, projectId);

        return new ResponseEntity<>(createdProblem, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Problem>> readProblems(@PathVariable long projectId) {
        final List<Problem> allProblems = problemService.readProblems(projectId);

        return new ResponseEntity<>(allProblems, HttpStatus.OK);
    }

    @PatchMapping("/{problemId}")
    public ResponseEntity<Problem> updateProblem(@Valid @RequestBody final ProblemDTO problemData, @PathVariable long projectId, @PathVariable long problemId) {
        final Problem updatedProblem = problemService.updateProblem(problemData, projectId, problemId);

        return new ResponseEntity<>(updatedProblem, HttpStatus.OK);
    }


    @DeleteMapping("/{problemId}")
    public ResponseEntity<Void> deleteProblem(@PathVariable long projectId, @PathVariable long problemId) {
        problemService.deleteProblem(projectId, problemId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
