package h.group.problemtracker.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ProblemDTO {
    private long projectId;

    @NotEmpty(message = "Title cannot be empty.")
    private String title;

    @NotEmpty(message = "Description cannot be empty.")
    private String description;

    private boolean finished;

    private Date started_at;

    @NotNull(message = "Starting value cannot be null.")
    @Min(value = 0, message = "Value must be greater than or equal to 0.")
    private int starting_value;

    @NotNull(message = "Goal value cannot be null.")
    @Min(value = 0, message = "Value must be greater than or equal to 0.")
    private int goal_value;

    @NotNull(message = "Potential profit cannot be null.")
    @Min(value = 0, message = "Value must be greater than or equal to 0.")
    private double potential_profit;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
    }

    public int getStarting_value() {
        return starting_value;
    }

    public void setStarting_value(int starting_value) {
        this.starting_value = starting_value;
    }

    public int getGoal_value() {
        return goal_value;
    }

    public void setGoal_value(int goal_value) {
        this.goal_value = goal_value;
    }

    public double getPotential_profit() {
        return potential_profit;
    }

    public void setPotential_profit(double potential_profit) {
        this.potential_profit = potential_profit;
    }
}
