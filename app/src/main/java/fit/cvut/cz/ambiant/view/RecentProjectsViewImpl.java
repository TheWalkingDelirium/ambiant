package fit.cvut.cz.ambiant.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.presenter.RecentProjectsAdapter;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectsView;

/**
 * Created by George on 06-March-17.
 *  An implementation of {@link RecentProjectsView} interface
 *
 */

public class RecentProjectsViewImpl implements RecentProjectsView, AbsListView.MultiChoiceModeListener {

    private View mRootView;

    private FloatingActionButton mOpenNewProjectFAB;
    private GridView mRecentProjectsGridView;

    private OpenNewFileListener mOpenNewFileListener;
    private OpenRecentFileListener mOpenRecentFileListener;
    private RemoveProjectListener mRemoveProjectListener;
    private OpenProjectDetailsListener mOpenProjectDetailsListener;
    private RecentProjectsAdapter mRecentProjectsAdapter;

    private int selectedCounter;

    public RecentProjectsViewImpl(LayoutInflater inflater, ViewGroup container, RecentProjectsAdapter adapter) {
        mRootView = inflater.inflate(R.layout.fragment_recent_projects, container, false);
        mRecentProjectsAdapter = adapter;

        initialize();

        mOpenNewProjectFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOpenNewFileListener.openNewFile();
            }
        });

        mRecentProjectsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mOpenRecentFileListener.openRecentFile(mRecentProjectsAdapter.getItem(position));
            }
        });

        mRecentProjectsGridView.setAdapter(adapter);
        mRecentProjectsGridView.setMultiChoiceModeListener(this);
    }

    private void initialize() {
        mOpenNewProjectFAB = (FloatingActionButton) mRootView.findViewById(R.id.open_file_fab);
        mRecentProjectsGridView = (GridView) mRootView.findViewById(R.id.recent_projects_grid_view);
    }

    @Override
    public void setAdapterToRecentProjectsList(RecentProjectsAdapter adapter) {
        this.mRecentProjectsAdapter = adapter;
        mRecentProjectsGridView.setAdapter(mRecentProjectsAdapter);
    }

    @Override
    public void setOpenRecentFileListener(OpenRecentFileListener listener) {
        this.mOpenRecentFileListener = listener;
    }

    @Override
    public void setOpenNewFileListener(OpenNewFileListener listener) {
        this.mOpenNewFileListener = listener;
    }

    @Override
    public void setRemoveProjectListener(RemoveProjectListener listener) {
        this.mRemoveProjectListener = listener;
    }

    @Override
    public void setOpenProjectDetailsListener(OpenProjectDetailsListener listener) {
        this.mOpenProjectDetailsListener = listener;
    }

    @Override
    public ListAdapter getRecentProjectsListAdapter() {
        return mRecentProjectsAdapter;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        // TODO remember the scrolling position
        return null;
    }

    //==============================================================================================
    // methods of the contextual menu
    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        if (checked) {
            selectedCounter++;
            mRecentProjectsAdapter.addSelection(id);
        }
        else {
            mRecentProjectsAdapter.removeSelection(id);
            selectedCounter--;
        }

        mode.setTitle("Selected " + selectedCounter);

        if (selectedCounter != 1)
            mode.getMenu().findItem(R.id.item_info).setVisible(false);
        else
            mode.getMenu().findItem(R.id.item_info).setVisible(true);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.rf_contextual_menu, menu);
        selectedCounter = 0;
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        if (item.getItemId() == R.id.item_info) {
            mOpenProjectDetailsListener.openProjectDetails(mRecentProjectsAdapter.getSelectedId().get(0));
        }

        if (item.getItemId() == R.id.item_delete) {
            mRemoveProjectListener.removeProjects(mRecentProjectsAdapter.getSelectedId());
        }

        mode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        selectedCounter = 0;
        mRecentProjectsAdapter.clearSelection();
    }
}
