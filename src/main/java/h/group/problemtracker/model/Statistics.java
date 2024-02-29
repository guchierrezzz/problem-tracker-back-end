package h.group.problemtracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column()
    private double pre_solution;

    @Column()
    private double post_solution;

    @Column()
    private double goal;

    @Column()
    private double potential_profit;

    public Statistics(long id, Problem problem, double pre_solution, double post_solution, double goal, double potential_profit) {
        this.id = id;
        this.problem = problem;
        this.pre_solution = pre_solution;
        this.post_solution = post_solution;
        this.goal = goal;
        this.potential_profit = potential_profit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
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

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public double getPotential_profit() {
        return potential_profit;
    }

    public void setPotential_profit(double potential_profit) {
        this.potential_profit = potential_profit;
    }
}
