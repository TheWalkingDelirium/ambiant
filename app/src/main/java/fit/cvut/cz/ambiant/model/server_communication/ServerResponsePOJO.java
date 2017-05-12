package fit.cvut.cz.ambiant.model.server_communication;

import java.util.ArrayList;

/**
 * Created by George on 07-May-17.
 */

public class ServerResponsePOJO {
    String status;
    String type;
    int count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
