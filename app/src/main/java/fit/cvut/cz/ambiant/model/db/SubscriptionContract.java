package fit.cvut.cz.ambiant.model.db;

import android.provider.BaseColumns;

/**
 * Created by George on 07-May-17.
 */

public final class SubscriptionContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SubscriptionContract() {}

    /* Inner class that defines the table contents */
    public static class Subscription implements BaseColumns {
        public static final String TABLE_NAME = "subscription";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SUBSCRIPTION_DATE= "subscription_date";
    }
}
