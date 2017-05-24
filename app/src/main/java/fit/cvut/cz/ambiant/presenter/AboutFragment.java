package fit.cvut.cz.ambiant.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.AboutViewImpl;
import fit.cvut.cz.ambiant.view.LicenseDialogFragment;
import fit.cvut.cz.ambiant.view.RecentProjectsViewImpl;
import fit.cvut.cz.ambiant.view.UserManualDialogFragment;
import fit.cvut.cz.ambiant.view.interfaces.AboutView;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectsView;

/**
 * Created by George.
 */

public class AboutFragment extends BaseFragment implements AboutView.OpenLicenseAgreementListener, AboutView.OpenUserManualListener {

    final static String LOG_TAG = "myLogs,AboutFragment";

    private AboutView mAboutView;


    public static AboutFragment newInstance() {
        Log.d(LOG_TAG, "newInstance()");
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Instantiate MVC view associated with this fragment
        Log.d(LOG_TAG, "onCreateView()");

        mAboutView = new AboutViewImpl(inflater, container);
        mAboutView.setOpenLicenseAgreementListener(this);
        mAboutView.setOpenUserManualListener(this);
        // Return the root view of the associated MVC view
        return mAboutView.getRootView();
    }

    @Override
    public void openLicenseAgreement() {
        LicenseDialogFragment dialog = LicenseDialogFragment.newInstance();
        dialog.show(getFragmentManager(), "LicensesDialog");
    }

    @Override
    public void openUserManual() {
        UserManualDialogFragment dialogFragment = UserManualDialogFragment.newInstance();
        dialogFragment.show(getFragmentManager(), "User Guide");
    }

    @Override
    public View getRootView() {
        return mAboutView.getRootView();
    }
}
