package h.group.problemtracker.service;

import h.group.problemtracker.dto.ProjectDTO;
import h.group.problemtracker.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    Project createProject(final ProjectDTO projectData);
    List<Project> readProjects();
    Project updateProject(ProjectDTO projectData, final long id);
    void deleteProject(final Long id);

}
