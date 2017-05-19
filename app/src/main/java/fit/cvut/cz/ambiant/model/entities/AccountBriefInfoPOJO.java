package fit.cvut.cz.ambiant.model.entities;

/**
 * Created by George on 07-May-17.
 */

public class AccountBriefInfoPOJO {
    int accountId;
    String accountName;
    String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AccountBriefInfoPOJO{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", description='" + description + '\'' +
                ", subscriptionToken='" + subscriptionToken + '\'' +
                '}';
    }
}

