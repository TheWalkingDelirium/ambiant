package fit.cvut.cz.ambiant.model.db.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Created by George on 07-May-17.
 */

public final class ProjectDAO {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ProjectEntry.TABLE_NAME + " (" +
                    ProjectEntry._ID + " INTEGER PRIMARY KEY," +
                    ProjectEntry.COLUMN_NAME_TITLE + " TEXT," +
                    ProjectEntry.COLUMN_NAME_DESC + " TEXT," +
                    ProjectEntry.COLUMN_NAME_AUTHOR + " TEXT," +
                    ProjectEntry.COLUMN_NAME_PATH + " TEXT," +
                    ProjectEntry.COLUMN_NAME_LAST_OPENED_DATE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ProjectEntry.TABLE_NAME;

    private ProjectDAO() {
    }

    public static ArrayList<Project> readRecentProjects(SQLiteDatabase db) {
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                ProjectEntry._ID,
                ProjectEntry.COLUMN_NAME_TITLE,
                ProjectEntry.COLUMN_NAME_DESC,
                ProjectEntry.COLUMN_NAME_AUTHOR,
                ProjectEntry.COLUMN_NAME_PATH
        };
//
//// Filter results WHERE "title" = 'My Title'
//        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
//        String[] selectionArgs = {"My Title"};

// How you want the results sorted in the resulting Cursor
        String sortOrder = ProjectEntry.COLUMN_NAME_LAST_OPENED_DATE + " DESC";

        Cursor cursor = db.query(
                ProjectEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder,                                 // The sort order
                "20"
        );

        ArrayList<Project> results = new ArrayList<>();

//        while (cursor.moveToNext()) {
//            int id = (int) cursor.getLong(cursor.getColumnIndexOrThrow(ProjectEntry._ID));
//            String title = cursor.getString(cursor.getColumnIndexOrThrow(ProjectEntry.COLUMN_NAME_TITLE));
//            String desc = cursor.getString(cursor.getColumnIndexOrThrow(ProjectEntry.COLUMN_NAME_DESC));
//            String author = cursor.getString(cursor.getColumnIndexOrThrow(ProjectEntry.COLUMN_NAME_AUTHOR));
//            String path = cursor.getString(cursor.getColumnIndexOrThrow(ProjectEntry.COLUMN_NAME_PATH));
//
//            Project p = new Project(id, author, title, path, desc);
//            results.add(p);//fixme
//        }

        cursor.close();

        return results;
    }

    public static long createProjectEntry(SQLiteDatabase db, Project project) {
        Calendar c = GregorianCalendar.getInstance();
        int seconds = c.get(Calendar.SECOND);
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ProjectEntry.COLUMN_NAME_TITLE, project.getName());
        values.put(ProjectEntry.COLUMN_NAME_DESC, project.getDescription());
        values.put(ProjectEntry.COLUMN_NAME_AUTHOR, project.getAuthor());
        values.put(ProjectEntry.COLUMN_NAME_LAST_OPENED_DATE, seconds);
        values.put(ProjectEntry.COLUMN_NAME_PATH, project.getPath());
        long rowID = db.insert(ProjectEntry.TABLE_NAME, null, values);
        return rowID;
    }

    public static void removeProjectEntry(SQLiteDatabase db, Project project) {
        // Define 'where' part of query.
        String selection = ProjectEntry._ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = {String.valueOf(project.getId())};
// Issue SQL statement.
        db.delete(ProjectEntry.TABLE_NAME, selection, selectionArgs);
    }

    public static void updateProjectEntry(SQLiteDatabase db, Project project) {
        Calendar c = GregorianCalendar.getInstance();
        int seconds = c.get(Calendar.SECOND);


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ProjectEntry.COLUMN_NAME_TITLE, project.getName());
        values.put(ProjectEntry.COLUMN_NAME_DESC, project.getDescription());
        values.put(ProjectEntry.COLUMN_NAME_AUTHOR, project.getAuthor());
        values.put(ProjectEntry.COLUMN_NAME_LAST_OPENED_DATE, seconds);
        values.put(ProjectEntry.COLUMN_NAME_PATH, project.getPath());

        // Which row to update, based on the title
        String selection = ProjectEntry._ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(project.getId())};

        db.update(ProjectEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    /* Inner class that defines the table contents */
    public static class ProjectEntry implements BaseColumns {
        public static final String TABLE_NAME = "project";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESC = "description";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_PATH = "path";
        public static final String COLUMN_NAME_LAST_OPENED_DATE = "last_date";
    }
}
