package fit.cvut.cz.ambiant.model;

import android.content.Context;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.db.Repository;
import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.model.server_communication.RESTClient;
import fit.cvut.cz.ambiant.presenter.SubscriptionsFragment;

/**
 * Created by George on 06-March-17.
 */

public class Interactor {

    private boolean unsubscribed = false;

    public void unsubscribe(int accountId) {
        unsubscribed = true;
        //TODO add interaction with server to delete the account token from server
        //TODO add interaction with database to remove this account entry from local DB
    }

    public void getSubscribedAccounts(OnAccountsUpdatedListener listener) {

        if (unsubscribed)
            return;

        AccountBriefInfoPOJO account = new AccountBriefInfoPOJO();
        account.setAccountId(1);
        account.setAccountName("Test account name");
        account.setDescription("Test account description");
        account.setSubscriptionToken("Test account subscription token");
        ArrayList<AccountBriefInfoPOJO> result = new ArrayList<>();
        result.add(account);
        listener.onAccountsUpdated(result);
    }

    public Project getProject(Long id) {
        Project mock = new Project(1, "author", "name", null, "description lorem ipsum dorem amet", null);//fixme
        return mock;
    }

    public interface RecentProjectsLoadedListener {

        void onRecentProjectUpdate(ArrayList<Project> projects);
    }

    private final Repository mRepository;
    private Context mApplicationContext;
    private RESTClient mRESTClient;

    public Interactor(Context context) {
        mApplicationContext = context.getApplicationContext();
        mRepository = fit.cvut.cz.ambiant.model.db.Repository.getInstance(mApplicationContext);
        mRESTClient = new RESTClient(mApplicationContext);
    }

    public void getRecentProjects(RecentProjectsLoadedListener listener) {
        //asyncload of projects;
        RecentProjectsAsyncTaskLoader task = new RecentProjectsAsyncTaskLoader(listener, mRepository);
        task.execute();
    }

    public void destroy() {
        mRepository.close();
    }


}
