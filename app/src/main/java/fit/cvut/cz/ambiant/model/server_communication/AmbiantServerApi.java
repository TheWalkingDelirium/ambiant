package fit.cvut.cz.ambiant.model.server_communication;

import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;
import fit.cvut.cz.ambiant.model.entities.MobileDevice;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by George on 07-May-17.
 */

public interface AmbiantServerApi {
    // Request method and URL specified in the annotation
    @POST("accounts/{id}/devices")
    Call<AccountBriefInfoPOJO> subscribe(@Path("id") int id, @Body MobileDevice device);

    @DELETE("accounts/{id}/devices/{deviceid}")
    Call<ResponseBody> unsubscribe(@Path("id") int id, @Path("deviceid") int deviceId, @Body String subscriptionToken);

    @GET("https://jsonplaceholder.typicode.com/posts")
    Call<ResponseBody> testAPI();
}
