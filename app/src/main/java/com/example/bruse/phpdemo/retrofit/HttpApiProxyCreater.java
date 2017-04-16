package com.example.bruse.phpdemo.retrofit;

import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by bruse on 2017/4/16.
 */

public class HttpApiProxyCreater {
    private static final ConcurrentHashMap<String, Retrofit> retrofitHashMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Object> clientHashMap = new ConcurrentHashMap<>();

    public HttpApiProxyCreater() {
    }
    public <T> T create(Class<T> classOfT) {
        String identity = classOfT.getName();
        Object client = clientHashMap.get(identity);
        if (client == null) {
            String baseUrl = "https://192.168.191.4";
            Retrofit retrofit = retrofitHashMap.get(baseUrl);
            if (retrofit == null) {
                retrofitHashMap.put(baseUrl, retrofit = createRetrofit(baseUrl));
            }
            clientHashMap.put(identity, client = retrofit.create(classOfT));
        }
        return (T) client;
    }

    private Retrofit createRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.3.227.33/pulamsi/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
