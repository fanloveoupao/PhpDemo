package com.example.bruse.phpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.bruse.phpdemo.ioc.APiServiceModule;
import com.example.bruse.phpdemo.ioc.ApiServiceComponent;
import com.example.bruse.phpdemo.ioc.DaggerApiServiceComponent;

/**
 * Created by bruse on 2017/4/16.
 */

public abstract class BasePresenterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        ApiServiceComponent component = DaggerApiServiceComponent
                .builder()
                .aPiServiceModule(new APiServiceModule())
                .build();
        injectActivity(component,this);
    }

    protected abstract void injectActivity(ApiServiceComponent component, BasePresenterActivity basePresenterActivity);

    protected abstract void initView(Bundle savedInstanceState);
}
