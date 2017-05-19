package fit.cvut.cz.ambiant.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.AboutViewImpl;
import fit.cvut.cz.ambiant.view.ProjectDetailViewImpl;
import fit.cvut.cz.ambiant.view.interfaces.ProjectDetailsView;

/**
 * Created by George.
 */

public class ProjectDetailsFragment extends BaseFragment {

    final static String LOG_TAG = "myLogs,ProjectDetails";

    private ProjectDetailsView mProjectDetailsView;
    private long id;

    public static ProjectDetailsFragment newInstance(int id) {
        
        Bundle args = new Bundle();
        args.putInt("id", id);
        ProjectDetailsFragment fragment = new ProjectDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Instantiate MVC view associated with this fragment
        Log.d(LOG_TAG, "onCreateView()");
        this.id = getArguments().getInt("id");
        mProjectDetailsView = new ProjectDetailViewImpl(inflater, container, getContext().getApplicationContext());
        // Return the root view of the associated MVC view
        return mProjectDetailsView.getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) getActivity();
        Project p = activity.getInteractor().getProject(this.id);
        mProjectDetailsView.setProjectDetails(p);
    }

    @Override
    public View getRootView() {
        return mProjectDetailsView.getRootView();
    }
}
