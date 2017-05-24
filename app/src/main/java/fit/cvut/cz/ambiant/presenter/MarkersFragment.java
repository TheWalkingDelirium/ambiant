package fit.cvut.cz.ambiant.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.ProjectDetailViewImpl;
import fit.cvut.cz.ambiant.view.interfaces.MarkerView;
import fit.cvut.cz.ambiant.view.interfaces.MarkerViewImpl;

/**
 * Created by George.
 */

public class MarkersFragment extends BaseFragment {

    private MarkerView mMarkerView;

    public static MarkersFragment newInstance() {

        Bundle args = new Bundle();

        MarkersFragment fragment = new MarkersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Instantiate MVC view associated with this fragment
        mMarkerView = new MarkerViewImpl(inflater, container, getContext().getApplicationContext());
        // Return the root view of the associated MVC view
        return mMarkerView.getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) getActivity();
    }

    @Override
    public View getRootView() {
        return mMarkerView.getRootView();
    }
}
