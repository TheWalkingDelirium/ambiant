package fit.cvut.cz.ambiant.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;

import fit.cvut.cz.ambiant.R;

/**
 * Created by George.
 */

public class UserManualDialogFragment extends DialogFragment {

    public static UserManualDialogFragment newInstance() {

        Bundle args = new Bundle();
        
        UserManualDialogFragment fragment = new UserManualDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.user_manual, null);

        return new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert)
                .setTitle(getString(R.string.user_manual_title))
                .setView(view)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
