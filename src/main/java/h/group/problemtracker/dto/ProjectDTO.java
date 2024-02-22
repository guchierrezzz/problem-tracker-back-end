package h.group.problemtracker.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProjectDTO {

    @NotEmpty(message = "Title cannot be empty")
    @Size(max = 30)
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 150)
    private String description;

    private String image_url;

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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
