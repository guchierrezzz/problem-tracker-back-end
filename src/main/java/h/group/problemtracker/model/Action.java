package h.group.problemtracker.model;

import h.group.problemtracker.enums.Status;
import jakarta.persistence.*;

import java.util.Date;



@Entity
@Table(name = "actions")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date started_at;

    @Temporal(TemporalType.DATE)
    private Date finished_at;

    public Action(long id, String description, Status status, Date started_at, Date finished_at) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.started_at = started_at;
        this.finished_at = finished_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
    }

    public Date getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(Date finished_at) {
        this.finished_at = finished_at;
    }
}
