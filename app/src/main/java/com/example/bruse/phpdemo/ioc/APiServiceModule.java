package com.example.bruse.phpdemo.ioc;

import com.example.bruse.phpdemo.retrofit.HttpApiProxyCreater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bruse on 2017/4/16.
 */
@Module
public class APiServiceModule {
    private HttpApiProxyCreater creater;

    public APiServiceModule() {
        creater = new HttpApiProxyCreater();
    }

    @Provides
    ProjecrApi providesApiFactory() {
        return creater.create(ProjecrApi.class);
    }

    @Provides
    @Singleton
    public ApiService providesApiService() {
        return new ApiService();
    }
}
