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
        Project project = new Project(1, "Example Combat Jet", "combat_jet", "file:///android_asset/example_models/combat_jet", "Combat jet description. Example project", true, null);//// FIXME
        result.add(0, project);

        Project project1 = new Project(2, "Example Knight", "knight", "file:///android_asset/example_models/knight", "Knight. example project", true, null);
        result.add(project1);

        Project project2 = new Project(3, "Example Teapot", "teapot", "file:///android_asset/example_models/teapot", "Teapot. example project", true, null);
        result.add(project2);
        listener.onRecentProjectUpdate(result);
    }
}
