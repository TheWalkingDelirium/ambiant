package fit.cvut.cz.ambiant.view.interfaces;

/**
 * Created by George.
 */

public interface AboutView extends MVPView {

    interface OpenLicenseAgreementListener {
        void openLicenseAgreement();
    }

    interface OpenUserManualListener {
        void openUserManual();
    }

    void displayAbout();

    void setOpenUserManualListener(OpenUserManualListener listener);
    void setOpenLicenseAgreementListener(OpenLicenseAgreementListener listener);
}
