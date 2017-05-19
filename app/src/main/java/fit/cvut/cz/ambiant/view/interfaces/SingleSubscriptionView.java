package fit.cvut.cz.ambiant.view.interfaces;

import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;

/**
 * Created by George.
 */

public interface SingleSubscriptionView extends MVPView {
    void setSubscriptionInfo(AccountBriefInfoPOJO accountBriefInfo, SubscriptionsView.SubscriptionManagementListener listener);
}
