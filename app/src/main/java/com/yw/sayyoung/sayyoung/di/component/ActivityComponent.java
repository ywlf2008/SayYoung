package com.yw.sayyoung.sayyoung.di.component;

import android.app.Activity;

import com.yw.sayyoung.sayyoung.di.module.ActivityModule;
import com.yw.sayyoung.sayyoung.di.scope.ActivityScope;
import com.yw.sayyoung.sayyoung.ui.activity.Login1Activity;
import com.yw.sayyoung.sayyoung.ui.activity.MainActivity;
import com.yw.sayyoung.sayyoung.ui.activity.OrderActivity;

import dagger.Component;

/**
 * @author quchao
 * @date 2017/11/27
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();

    /**
     * 注入MAinActivity所需的依赖
     *
     * @param mainActivity MainActivity
     */
    void inject(MainActivity mainActivity);

    /**
     * 注入MAinActivity所需的依赖
     *
     * @param loginActivity Login1Activity
     */
    void inject(Login1Activity loginActivity);

    /**
     * 注入MAinActivity所需的依赖
     *
     * @param orderActivity OrderActivity
     */
    void inject(OrderActivity orderActivity);

//    /**
//     * 注入SplashActivity所需的依赖
//     *
//     * @param splashActivity SplashActivity
//     */
//    void inject(SplashActivity splashActivity);
//
//    /**
//     * 注入ArticleDetailActivity所需的依赖
//     *
//     * @param articleDetailActivity ArticleDetailActivity
//     */
//    void inject(ArticleDetailActivity articleDetailActivity);
//
//    /**
//     * 注入KnowledgeHierarchyDetailActivity所需的依赖
//     *
//     * @param knowledgeHierarchyDetailActivity KnowledgeHierarchyDetailActivity
//     */
//    void inject(KnowledgeHierarchyDetailActivity knowledgeHierarchyDetailActivity);
//
//    /**
//     * 注入LoginActivity所需的依赖
//     *
//     * @param loginActivity LoginActivity
//     */
//    void inject(LoginActivity loginActivity);
//
//    /**
//     * 注入AboutUsActivity所需的依赖
//     *
//     * @param aboutUsActivity AboutUsActivity
//     */
//    void inject(AboutUsActivity aboutUsActivity);
//
//    /**
//     * 注入SearchListActivity所需的依赖
//     *
//     * @param searchListActivity SearchListActivity
//     */
//    void inject(SearchListActivity searchListActivity);

}
