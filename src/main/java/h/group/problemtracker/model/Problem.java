package h.group.problemtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "problems")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column()
    private boolean finished;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date started_at;

    @Column(nullable = false)
    private int starting_value;

    @Column(nullable = false)
    private int goal_value;

    @Column(nullable = false)
    private double potential_profit;

    @PrePersist
    protected void onCreate() {
        started_at = new Date();
    }

    public Problem() {
    }

    public Problem(Project project, String title, String description, boolean finished, Date started_at, int starting_value, int goal_value, double potential_profit) {
        this.project = project;
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.started_at = started_at;
        this.starting_value = starting_value;
        this.goal_value = goal_value;
        this.potential_profit = potential_profit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

