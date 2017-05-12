package fit.cvut.cz.ambiant.model.server_communication;

/**
 * Created by George on 07-May-17.
 */

public class AccountBriefInfoPOJO {
    int accountId;
    String accountName;
    String subscriptionToken;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSubscriptionToken() {
        return subscriptionToken;
    }

    public void setSubscriptionToken(String subscriptionToken) {
        this.subscriptionToken = subscriptionToken;
    }
}
