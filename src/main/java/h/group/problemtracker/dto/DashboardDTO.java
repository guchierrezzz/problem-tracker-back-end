package h.group.problemtracker.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class DashboardDTO {
    private long problemId;

    @NotEmpty(message = "Title cannot be empty")
    private long title;

    @NotEmpty(message = "URL cannot be empty")
    private long url;
}
