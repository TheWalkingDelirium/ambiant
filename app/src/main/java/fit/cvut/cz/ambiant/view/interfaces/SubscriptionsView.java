package fit.cvut.cz.ambiant.view.interfaces;

import fit.cvut.cz.ambiant.presenter.SubscriptionsAdapter;

/**
 * Created by George.
 */

public interface SubscriptionsView extends MVPView {
    interface SubscriptionManagementListener {
        void subscribe();
        void unsubscribe(int accountId);
    }

    void setSubscriptionsAdapter(SubscriptionsAdapter adapter);

    void SubscriptionManagementListener(SubscriptionManagementListener listener);
}
