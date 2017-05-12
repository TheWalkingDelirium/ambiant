package fit.cvut.cz.ambiant.view.interfaces;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.presenter.RecentProjectsAdapter;

/**
 * Created by George on 06-March-17.
 */

/**
 * This interface corresponds to "recent projects" screen of the app, where recent and example projects are listed
 */
public interface RecentProjectsView extends MVPView {
    //TODO add removing a project from the list;
    //TODO removing project from memory;
    //TODO showing the information about a project;

    interface OpenNewFileListener {
        /**
         * This callback will be invoked when "open new project" button is being clicked
         */
        void openNewFile();
    }

    interface OpenRecentFileListener {
        /**
         * This callback will be invoked when any element of the list is being clicked
         */
        void openRecentFile(Object project);
    }

    interface RemoveProjectListener {
        /**
         * This callback will be invoked when delete item of contextual menu will be clicked
         *
         * @param idOfProjects collection of id of each project to delete
         */
        void removeProjects(ArrayList<Long> idOfProjects);
    }

    interface OpenProjectDetailsListener {
        /**
         * This callback will be invoked when details item of contextual menu will be clicked
         *
         * @param id of the project to open details
         */
        void openProjectDetails(Long id);
    }

    ;

    /**
     * Bind the adapter to the recent projects listview (or gridview).
     *
     * @param adapter custom adapter that will provide data for representation a project list on the UI
     */
    void setAdapterToRecentProjectsList(RecentProjectsAdapter adapter);


    /**
     * Set a listener that will be notified by this MVP view
     *
     * @param listener listener that should be notified; null to clear
     */
    void setOpenRecentFileListener(OpenRecentFileListener listener);

    /**
     * Set a listener that will be notified by this MVP view
     *
     * @param listener listener that should be notified; null to clear
     */
    void setOpenNewFileListener(OpenNewFileListener listener);

    /**
     * Set a listener that will be notified by this MVP view
     *
     * @param listener listener that should be notified; null to clear
     */
    void setRemoveProjectListener(RemoveProjectListener listener);

    /**
     * Set a listener that will be notified by this MVP view
     *
     * @param listener listener that should be notified; null to clear
     */
    void setOpenProjectDetailsListener(OpenProjectDetailsListener listener);


    ListAdapter getRecentProjectsListAdapter();
}
