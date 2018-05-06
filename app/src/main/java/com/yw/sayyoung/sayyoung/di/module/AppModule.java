package com.yw.sayyoung.sayyoung.di.module;


import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.core.DataManager;
import com.yw.sayyoung.sayyoung.core.db.DbHelper;
import com.yw.sayyoung.sayyoung.core.db.GreenDaoHelper;
import com.yw.sayyoung.sayyoung.core.http.HttpHelper;
import com.yw.sayyoung.sayyoung.core.http.RetrofitHelper;
import com.yw.sayyoung.sayyoung.core.prefs.PreferenceHelper;
import com.yw.sayyoung.sayyoung.core.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author quchao
 * @date 2017/11/27
 */

@Module
public class AppModule {

    private final SayYoungApp application;

    public AppModule(SayYoungApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    SayYoungApp provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(GreenDaoHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }

}
