package fit.cvut.cz.ambiant.model;

import android.os.AsyncTask;
import java.util.ArrayList;
import fit.cvut.cz.ambiant.model.Interactor;
import fit.cvut.cz.ambiant.model.db.Repository;
import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Created by George.
 */
public class RecentProjectsAsyncTaskLoader extends AsyncTask<Void, Void, ArrayList<Project>> {

    private final Interactor.RecentProjectsLoadedListener listener;
    private final Repository repository;

    public RecentProjectsAsyncTaskLoader(Interactor.RecentProjectsLoadedListener listener, Repository repository) {
        this.listener = listener;
        this.repository = repository;
    }

    @Override
    protected ArrayList<Project> doInBackground(Void... params) {
        return repository.readRecentProjectsEntries();
    }

    @Override
    protected void onPostExecute(ArrayList<Project> result) {
        super.onPostExecute(result);
        listener.onRecentProjectUpdate(result);
    }
}
