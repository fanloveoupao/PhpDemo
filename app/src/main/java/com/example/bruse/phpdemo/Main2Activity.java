package com.example.bruse.phpdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bruse.phpdemo.base.BasePresenterActivity;
import com.example.bruse.phpdemo.ioc.APiServiceModule;
import com.example.bruse.phpdemo.ioc.ApiService;
import com.example.bruse.phpdemo.ioc.ApiServiceComponent;
import com.example.bruse.phpdemo.ioc.DaggerApiServiceComponent;

import javax.inject.Inject;

public class Main2Activity extends BasePresenterActivity {
    @Inject
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void injectActivity(ApiServiceComponent component, Main2Activity main2Activity) {
         component.inject(main2Activity);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main2);

        apiService.showService();
    }

}
