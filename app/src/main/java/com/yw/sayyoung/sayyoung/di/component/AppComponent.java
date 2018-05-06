package com.yw.sayyoung.sayyoung.di.component;


import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.core.DataManager;
import com.yw.sayyoung.sayyoung.di.module.AppModule;
import com.yw.sayyoung.sayyoung.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    SayYoungApp getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
