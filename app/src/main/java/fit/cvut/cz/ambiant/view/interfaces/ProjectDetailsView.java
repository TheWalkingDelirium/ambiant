package fit.cvut.cz.ambiant.view.interfaces;

import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Created by George.
 */

public interface ProjectDetailsView extends MVPView {
    void setProjectDetails(Project projectDetails);
}
