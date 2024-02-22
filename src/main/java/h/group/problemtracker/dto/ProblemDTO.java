package h.group.problemtracker.dto;

import jakarta.validation.constraints.NotEmpty;

public class ProblemDTO {
    private long projectId;

    @NotEmpty(message = "Description cannot be empty.")
    private String description;

    private double pre_solution;

    private double post_solution;

    private double potential_profit;

    private boolean finished;

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPre_solution() {
        return pre_solution;
    }

    public void setPre_solution(double pre_solution) {
        this.pre_solution = pre_solution;
    }

    public double getPost_solution() {
        return post_solution;
    }

    public void setPost_solution(double post_solution) {
        this.post_solution = post_solution;
    }

    public double getPotential_profit() {
        return potential_profit;
    }

    public void setPotential_profit(double potential_profit) {
        this.potential_profit = potential_profit;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
