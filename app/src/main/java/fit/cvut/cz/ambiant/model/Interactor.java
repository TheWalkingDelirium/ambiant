package fit.cvut.cz.ambiant.model;

import android.content.Context;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.db.Repository;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.model.server_communication.RESTClient;

/**
 * Created by George on 06-March-17.
 */

public class Interactor {

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
