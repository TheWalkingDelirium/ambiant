package fit.cvut.cz.ambiant.model.firebase_messaging;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by George.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FirebaseMessagingSrvc";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "Received message: " + remoteMessage.getFrom() + "\n" + remoteMessage.getNotification().getBody());
    }
}
