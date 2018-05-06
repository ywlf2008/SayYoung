package com.yw.sayyoung.sayyoung.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;
import android.support.v4.content.ContextCompat;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;
import com.yw.sayyoung.sayyoung.BuildConfig;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.core.bean.Account;
import com.yw.sayyoung.sayyoung.core.dao.DaoMaster;
import com.yw.sayyoung.sayyoung.core.dao.DaoSession;
import com.yw.sayyoung.sayyoung.di.component.AppComponent;
import com.yw.sayyoung.sayyoung.di.component.DaggerAppComponent;
import com.yw.sayyoung.sayyoung.di.module.AppModule;
import com.yw.sayyoung.sayyoung.di.module.HttpModule;
import com.yw.sayyoung.sayyoung.utils.logger.TxtFormatStrategy;

public class SayYoungApp extends Application{

    private static SayYoungApp instance;
    private RefWatcher refWatcher;
    public static boolean isFirstRun;
    private static volatile AppComponent appComponent;
    public Account mAccount;

    //static 代码段可以防止内存泄露, 全局设置刷新头部及尾部，优先级最低
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater((context, refreshLayout) -> {
            //全局设置主题颜色
            refreshLayout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
            //指定为Delivery Header，默认是贝塞尔雷达Header
            return new DeliveryHeader(context);
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater((context, layout) -> {
            //默认是 BallPulseFooter
            return new BallPulseFooter(context).setAnimatingColor(ContextCompat.getColor(context, R.color.colorPrimary));
        });
    }

    private DaoSession mDaoSession;

    public static synchronized SayYoungApp getInstance() {
        return instance;
    }

    public static RefWatcher getRefWatcher(Context context) {
        SayYoungApp application = (SayYoungApp) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initGreenDao();

        refWatcher = LeakCanary.install(this);

        initBugly();

        initLogger();

    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    private void initLogger() {
        //DEBUG版本才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                    tag(getString(R.string.app_name)).build()));
        }
        //把log存到本地
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().
                tag(getString(R.string.app_name)).build(getPackageName(), getString(R.string.app_name))));
    }

    private void initBugly() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
//        String processName = CommonUtils.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
//        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLY_ID, false, strategy);
    }

    public static synchronized AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

}
