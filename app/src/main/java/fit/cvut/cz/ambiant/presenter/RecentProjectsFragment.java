package fit.cvut.cz.ambiant.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.Interactor;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.RecentProjectsViewImpl;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectsView;

/**
 * Created by George on 06-March-17.
 */

public class RecentProjectsFragment extends BaseFragment implements RecentProjectsView.OpenNewFileListener, RecentProjectsView.OpenRecentFileListener, Interactor.RecentProjectsLoadedListener, RecentProjectsView.RemoveProjectListener, RecentProjectsView.OpenProjectDetailsListener {

    final static String LOG_TAG = "myLogs,RecentProjectsFr";

    private RecentProjectsView mRecentProjectsView;
    private RecentProjectsAdapter mRecentProjectsAdapter;
    private ArrayList<Project> mProjects;


    public static RecentProjectsFragment newInstance() {
        Log.d(LOG_TAG, "newInstance()");
        Bundle args = new Bundle();
        RecentProjectsFragment fragment = new RecentProjectsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(LOG_TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate()");
        mProjects = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Instantiate MVC view associated with this fragment
        Log.d(LOG_TAG, "onCreateView()");
        mRecentProjectsAdapter = new RecentProjectsAdapter(getContext(), inflater, mProjects);
        mRecentProjectsView = new RecentProjectsViewImpl(inflater, container, mRecentProjectsAdapter);
        mRecentProjectsView.setOpenNewFileListener(this);
        mRecentProjectsView.setOpenRecentFileListener(this);
        mRecentProjectsView.setRemoveProjectListener(this);
        mRecentProjectsView.setOpenProjectDetailsListener(this);

        if (getContext() == null) {
            throw new RuntimeException("Context is null, possibly activity is not created yet");
        }

        // Return the root view of the associated MVC view
        return mRecentProjectsView.getRootView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "onActivityCreated()");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "onViewCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
        MainActivity activity = (MainActivity) getActivity();
        activity.getInteractor().getRecentProjects(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "OnStop()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "onDetach()");
    }

    @Override
    public void openNewFile() {
        Snackbar.make(mRecentProjectsView.getRootView(), "Open SAF dialog", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
        //TODO open SAF, create the Project object using some utility, then open AR activity and send project as a parameter
    }

    @Override
    public void openRecentFile(Object project) {
        Snackbar.make(mRecentProjectsView.getRootView(), "Open file", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    @Override
    public void onRecentProjectUpdate(ArrayList<Project> projects) {
        Log.d("RecentProjectsFragment", "onRecentProjectUpdate, size of array: " + projects.size());
        Project project = new Project(1,"Combat jet", "tyan", "file:///android_asset/example_models/combat_jet", "Combat jet description", true);
        projects.add(0, project);

        this.mProjects.addAll(projects);
        mRecentProjectsAdapter.notifyDataSetChanged();
    }

    @Override
    public void removeProjects(ArrayList<Long> idOfProjects) {
        Snackbar.make(mRecentProjectsView.getRootView(), "Delete", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    @Override
    public void openProjectDetails(Long id) {
        Snackbar.make(mRecentProjectsView.getRootView(), "Details", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }
}
