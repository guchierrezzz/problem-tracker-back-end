package h.group.problemtracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "problems")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(nullable = false)
    private String description;

    @Column()
    private double pre_solution;

    @Column()
    private double post_solution;

    @Column()
    private double potential_profit;

    @Column()
    private boolean finished;

    public Problem(long id, Project project, String description, double pre_solution, double post_solution, double potential_profit, boolean finished) {
        this.id = id;
        this.project = project;
        this.description = description;
        this.pre_solution = pre_solution;
        this.post_solution = post_solution;
        this.potential_profit = potential_profit;
        this.finished = finished;
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
