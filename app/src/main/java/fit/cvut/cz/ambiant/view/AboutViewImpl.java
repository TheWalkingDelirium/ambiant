package fit.cvut.cz.ambiant.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.view.interfaces.AboutView;

/**
 * Created by George.
 */

public class AboutViewImpl implements AboutView {

    private View mRootView;

    private Button openUserManualButton;
    private Button openLicenseAgreementButton;
    private OpenLicenseAgreementListener licenseAgreementListener;
    private OpenUserManualListener userManualListener;

    public AboutViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_about, container, false);
        openUserManualButton = (Button) mRootView.findViewById(R.id.open_usermanual_button);
        openLicenseAgreementButton = (Button) mRootView.findViewById(R.id.open_licenseagrement_button);

        openUserManualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManualListener.openUserManual();
            }
        });

        openLicenseAgreementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licenseAgreementListener.openLicenseAgreement();
            }
        });
    }

    @Override
    public void displayAbout() {

    }

    @Override
    public void setOpenUserManualListener(OpenUserManualListener listener) {
        this.userManualListener = listener;
    }

    @Override
    public void setOpenLicenseAgreementListener(OpenLicenseAgreementListener listener) {
        this.licenseAgreementListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
