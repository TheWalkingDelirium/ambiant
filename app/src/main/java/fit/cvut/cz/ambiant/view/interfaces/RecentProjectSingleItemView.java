package fit.cvut.cz.ambiant.view.interfaces;

import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Created by George on 07-May-17.
 */

public interface RecentProjectSingleItemView extends MVPView {
    void setProjectBriefInformation(Project project);
}
