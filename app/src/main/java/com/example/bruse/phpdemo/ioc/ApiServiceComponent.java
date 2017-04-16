package com.example.bruse.phpdemo.ioc;

import com.example.bruse.phpdemo.Main2Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bruse on 2017/4/16.
 */
@Singleton
@Component(modules = APiServiceModule.class)
public interface ApiServiceComponent {
    //定义注入的方法
    void inject(Main2Activity main2Activity);
}
