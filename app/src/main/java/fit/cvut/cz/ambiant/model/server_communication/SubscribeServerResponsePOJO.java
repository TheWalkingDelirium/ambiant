package fit.cvut.cz.ambiant.model.server_communication;

/**
 * Created by George on 07-May-17.
 */

public class SubscribeServerResponsePOJO extends ServerResponsePOJO {
    AccountBriefInfoPOJO account;

    public AccountBriefInfoPOJO getAccount() {
        return account;
    }

    public void setAccount(AccountBriefInfoPOJO account) {
        this.account = account;
    }
}
