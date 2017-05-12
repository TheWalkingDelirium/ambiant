package fit.cvut.cz.ambiant.model.db;

import android.provider.BaseColumns;

/**
 * Created by George on 07-May-17.
 */

public final class MarkerContract {
    private MarkerContract() {}

    /* Inner class that defines the table contents */
    public static class MarkerEntry implements BaseColumns {
            public static final String TABLE_NAME = "marker";
            public static final String COLUMN_NAME_NAME = "name";
            public static final String COLUMN_NAME_IMG_PATH = "img_path";
    }
}
