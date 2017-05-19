package fit.cvut.cz.ambiant.model;

import java.util.List;

import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;

/**
 * Created by George.
 */

public interface OnAccountsUpdatedListener {
    void onAccountsUpdated(List<AccountBriefInfoPOJO> accounts);
}
