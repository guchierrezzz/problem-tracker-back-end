package h.group.problemtracker.service.impl;

import h.group.problemtracker.dto.ProjectDTO;
import h.group.problemtracker.exception.AppException;
import h.group.problemtracker.model.Project;
import h.group.problemtracker.repository.ProjectRepository;
import h.group.problemtracker.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(final ProjectDTO projectData) {
        Project newProject = new Project(projectData.getTitle(), projectData.getDescription(), projectData.getImage_url());
        return projectRepository.save(newProject);
    }

    public List<Project> readProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(ProjectDTO projectData, final long id) {
        final Project foundProject = projectRepository.findById(id).orElseThrow(() -> new AppException("Project not found", HttpStatus.NOT_FOUND));

        foundProject.setTitle((projectData.getTitle() == null) ? foundProject.getTitle() : projectData.getTitle());
        foundProject.setDescription((projectData.getDescription() == null) ? foundProject.getDescription() : projectData.getDescription());
        foundProject.setImage_url((projectData.getImage_url() == null) ? foundProject.getImage_url() : projectData.getImage_url());

        return projectRepository.save(foundProject);
    }

    public void deleteProject(final Long id) {
        final Project foundProject = projectRepository.findById(id).orElseThrow(() -> new AppException("Project not found", HttpStatus.NOT_FOUND));
        projectRepository.delete(foundProject);
    }
}
