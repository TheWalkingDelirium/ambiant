package fit.cvut.cz.ambiant.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.webkit.WebView;

import fit.cvut.cz.ambiant.R;

/**
 * Created by George.
 */

public class LicenseDialogFragment extends DialogFragment {

    public static LicenseDialogFragment newInstance() {

        Bundle args = new Bundle();

        LicenseDialogFragment fragment = new LicenseDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        WebView view = (WebView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_license, null);
        view.loadUrl("file:///android_asset/license.html");
        return new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Light_Dialog_Alert)
                .setTitle(getString(R.string.action_licenses))
                .setView(view)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
