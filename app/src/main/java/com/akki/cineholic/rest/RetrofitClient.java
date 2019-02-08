package com.akki.cineholic.rest;


import com.akki.cineholic.util.ApiConstants;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public enum RetrofitClient {
    INSTANCE;

    private static final String TAG = RetrofitClient.class.getSimpleName();

    private volatile Retrofit sRetrofit = null;
    private String baseUrl = ApiConstants.BASE_URL;
    private ApiServices retrofitService;


    RetrofitClient() {
        sRetrofit = initRetrofit(baseUrl);
        retrofitService = sRetrofit.create(ApiServices.class);
    }

    public static RetrofitClient getInstance() {
        return INSTANCE;
    }

    public ApiServices getApiService() {
        return retrofitService;
    }

    private Retrofit initRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(createClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
    }


    private OkHttpClient createClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS).
                        build();
        return client;

    }

  /*  private Interceptor createInterceptor() {
        return chain -> {
            Request request = chain.request();
            if (request.method().equals("GET")) {
                if (LiveNetworkMonitor.isConnected(HopApplication.getApplication())) {
                    Log.d(TAG, "intercept:  Intercept  connected " + request.url());
                    request.newBuilder().header("Cache-Control", "only-if-cached").build();
                } else {
                    Log.d(TAG, "intercept:  Intercept not connected " + request.url());
                    request.newBuilder().header("Cache-Control", String.format(Locale.getDefault(), "public,   max-stale=%d", 86400));
                }
            }
            Response response = chain.proceed(request);
            //Re-write response CC Header to  force use of cache
            return response.newBuilder()
                    .header("Cache-Control", "public, max-age=86400")
                    .header("Pragma", "public")
                    .build();
        };
    }*/


}