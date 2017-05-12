package fit.cvut.cz.ambiant.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.db.DAO.ProjectDAO;
import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Created by George on 07-May-17.
 */

public class Repository extends SQLiteOpenHelper {

    private static Repository sInstance;
    private static SQLiteDatabase mDB;
    // If you change the database schema, you must increment the database version.

    private static final String DATABASE_NAME = "Ambiant.db";
    private static final int DATABASE_VERSION = 1;

    public static synchronized Repository getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new Repository(context.getApplicationContext());
        }
        if(mDB == null || !mDB.isOpen())
            mDB = sInstance.getWritableDatabase();
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private Repository(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProjectDAO.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ProjectDAO.SQL_DELETE_ENTRIES);
    }

    public ArrayList<Project> readRecentProjectsEntries() {
        return ProjectDAO.readRecentProjects(mDB);
    }

    public void createProjectEntry(Project p) {
        ProjectDAO.createProjectEntry(mDB, p);
    }

    public void removeProjectEntry(Project p) {
        ProjectDAO.removeProjectEntry(mDB, p);
    }

    public void updateProjectEntry(Project p) {
        ProjectDAO.removeProjectEntry(mDB, p);
    }


}
