package fit.cvut.cz.ambiant.model.server_communication;

import android.content.Context;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.model.server_communication.AmbiantServerApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by George on 07-May-17.
 */

public class RESTClient implements Callback<ResponseBody> {
    // our rest mAmbiantServer base url
    // Trailing slash is needed
    private static final String BASE_URL = "http://api.myservice.com/";

    AmbiantServerApi mAmbiantServer;
    Retrofit mRetrofit;


    public RESTClient(Context context) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mAmbiantServer = mRetrofit.create(AmbiantServerApi.class);
    }

    public void subscribe(int accountId, int deviceId, String token) {
//        Call<AccountBriefInfoPOJO> call = mAmbiantServer.subscribe(accountId, deviceId, token);
//        call.enqueue(this);
    }

    public void unsubscribe(int accountId, int deviceId, String token) {
        Call<ResponseBody> call = mAmbiantServer.unsubscribe(accountId, deviceId, token);
        call.enqueue(this);
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

    }
}
