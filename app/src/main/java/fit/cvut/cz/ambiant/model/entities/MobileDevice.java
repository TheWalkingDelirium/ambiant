package fit.cvut.cz.ambiant.model.entities;

/**
 * Created by George.
 */

public class MobileDevice {
    int id;
    String name;
    String fcmToken;

    public MobileDevice(int id, String name, String fcmToken) {
        this.id = id;
        this.name = name;
        this.fcmToken = fcmToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
