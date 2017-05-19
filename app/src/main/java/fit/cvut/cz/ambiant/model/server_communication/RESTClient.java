package fit.cvut.cz.ambiant.model.server_communication;

import android.content.Context;
import android.util.Log;

import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;
import fit.cvut.cz.ambiant.model.entities.MobileDevice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by George on 07-May-17.
 */

public class RESTClient {
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

    public void subscribe(int accountId, int deviceId, String deviceName, String fcmToken) {
        MobileDevice device = new MobileDevice(deviceId, deviceName, fcmToken);
        Call<AccountBriefInfoPOJO> call = mAmbiantServer.subscribe(accountId, device);
        call.enqueue(new Callback<AccountBriefInfoPOJO>() {
            @Override
            public void onResponse(Call<AccountBriefInfoPOJO> call, Response<AccountBriefInfoPOJO> response) {
                Log.d("RESTClient, subscribe:", response.body().toString());
                AccountBriefInfoPOJO accountBriefInfoPOJO = response.body();
                //TODO add account to the database
            }

            @Override
            public void onFailure(Call<AccountBriefInfoPOJO> call, Throwable t) {
                Log.e("RESTClient, subscribe:", t.getMessage());
            }
        });
    }

    public void unsubscribe(int accountId, int deviceId, String token) {
//        Call<ResponseBody> call = mAmbiantServer.unsubscribe(accountId, deviceId, token);
//        call.enqueue(this);
    }


}
