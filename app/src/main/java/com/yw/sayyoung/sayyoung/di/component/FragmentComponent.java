package com.yw.sayyoung.sayyoung.di.component;

import android.app.Activity;

import com.yw.sayyoung.sayyoung.di.module.FragmentModule;
import com.yw.sayyoung.sayyoung.di.scope.FragmentScope;
import com.yw.sayyoung.sayyoung.ui.fragment.MainPagerFragment;
import com.yw.sayyoung.sayyoung.ui.fragment.OrderDetailFragment;
import com.yw.sayyoung.sayyoung.ui.fragment.OrderPayFragment;
import com.yw.sayyoung.sayyoung.ui.fragment.ShoppingCartFragment;

import dagger.Component;

/**
 * @author quchao
 * @date 2017/11/27
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();

//    /**
//     * 注入MainPagerFragment所需的依赖
//     *
//     * @param mainPagerFragment MainPagerFragment
//     */
//    void inject(MainPagerFragment mainPagerFragment);
//
//    /**
//     * 注入KnowledgeHierarchyFragment所需的依赖
//     *
//     * @param knowledgeHierarchyFragment KnowledgeHierarchyFragment
//     */
//    void inject(KnowledgeHierarchyFragment knowledgeHierarchyFragment);
//
//    /**
//     * 注入KnowledgeHierarchyListFragment所需的依赖
//     *
//     * @param knowledgeHierarchyListFragment KnowledgeHierarchyListFragment
//     */
//    void inject(KnowledgeHierarchyListFragment knowledgeHierarchyListFragment);
//
//    /**
//     * 注入VideoFrequencyFragment所需的依赖
//     *
//     * @param projectFragment ProjectFragment
//     */
//    void inject(ProjectFragment projectFragment);
//
//    /**
//     * 注入NewsFragment所需的依赖
//     *
//     * @param navigationFragment NavigationFragment
//     */
//    void inject(NavigationFragment navigationFragment);
//
//    /**
//     * 注入ProjectListFragment所需的依赖
//     *
//     * @param projectListFragment ProjectListFragment
//     */
//    void inject(ProjectListFragment projectListFragment);
//
//    /**
//     * 注入ProjectListFragment所需的依赖
//     *
//     * @param searchDialogFragment SearchDialogFragment
//     */
//    void inject(SearchDialogFragment searchDialogFragment);
//
//    /**
//     * 注入UsageDialogFragment所需的依赖
//     *
//     * @param usageDialogFragment UsageDialogFragment
//     */
//    void inject(UsageDialogFragment usageDialogFragment);
//
//    /**
//     * 注入CollectFragment所需的依赖
//     *
//     * @param collectFragment CollectFragment
//     */
//    void inject(CollectFragment collectFragment);
//

    /**
     * 注入MainPagerFragment所需的依赖
     *
     * @param mainPagerFragment
     */
    void inject(MainPagerFragment mainPagerFragment);

    /**
     * 注入ShoppingCartFragment所需的依赖
     *
     * @param shoppingCartFragment
     */
    void inject(ShoppingCartFragment shoppingCartFragment);

    /**
     * 注入OrderDetailFragment所需的依赖
     *
     * @param orderDetailFragment
     */
    void inject(OrderDetailFragment orderDetailFragment);

    /**
     * 注入OrderDetailFragment所需的依赖
     *
     * @param orderPayFragment
     */
    void inject(OrderPayFragment orderPayFragment);

}
