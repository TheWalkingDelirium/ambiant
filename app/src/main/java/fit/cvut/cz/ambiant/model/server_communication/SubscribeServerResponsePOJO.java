package fit.cvut.cz.ambiant.model.server_communication;

import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;

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
