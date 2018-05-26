package com.yw.sayyoung.sayyoung.app;

import android.graphics.Color;

import com.yw.sayyoung.sayyoung.R;

import java.io.File;

public class Constants {

    static final String  BUGLY_ID = "1b5ce5ffb6";

    /**
     * url
     */
    public static final String COOKIE = "Cookie";

    /**
     * Path
     */
    public static final String PATH_DATA = SayYoungApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    /**
     * Tag fragment classify
     */
    public static final int TYPE_MAIN_PAGER = 0;

    public static final int TYPE_KNOWLEDGE = 1;

    public static final int TYPE_NAVIGATION = 2;

    public static final int TYPE_PROJECT = 3;

    public static final int TYPE_COLLECT = 4;

    public static final int TYPE_SETTING = 5;


    /**
     * Bottom Navigation tab classify
     */
    public static final int TAB_ONE = 0;

    /**
     * Intent params
     */
    public static final String ARG_PARAM1 = "param1";

    public static final String ARG_PARAM2 = "param2";

    /**
     * Tab colors
     */
    public static final int[] TAB_COLORS = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };


    /**
     * Main Pager
     */
    public static final String SEARCH_TEXT = "search_text";

    public static final String MENU_BUILDER = "MenuBuilder";

    public static final String LOGIN_DATA = "login_data";

    public static final String BANNER_DATA = "banner_data";

    public static final String ARTICLE_DATA = "article_data";

    /**
     * Refresh theme color
     */
    public static final int BLUE_THEME = R.color.colorPrimary;

    /**
     * Avoid double click time area
     */
    public static final long CLICK_TIME_AREA = 1000;


    public static final String ARTICLE_LINK = "article_link";

    public static final String ARTICLE_TITLE = "article_title";

    public static final String ARTICLE_ID = "article_id";

    public static final String IS_COLLECT = "is_collect";

    public static final String IS_COMMON_SITE = "is_common_site";

    public static final String IS_COLLECT_PAGE = "is_collect_page";

    public static final String CHAPTER_ID = "chapter_id";

    public static final String IS_SINGLE_CHAPTER = "is_single_chapter";

    public static final String CHAPTER_NAME = "is_chapter_name";

    public static final String SUPER_CHAPTER_NAME = "super_chapter_name";

    static final String DB_NAME = "aws_wan_android.db";

    public static final String CURRENT_PAGE = "current_page";

    public static final String PROJECT_CURRENT_PAGE = "project_current_page";

    /**
     * Shared Preference key
     */
    public static final String ACCOUNT = "account";

    public static final String PASSWORD = "password";

    public static final String LOGIN_STATUS = "login_status";

    public static final String AUTO_CACHE_STATE = "auto_cache_state";

    public static final String NO_IMAGE_STATE = "no_image_state";

    public static final String NIGHT_MODE_STATE = "night_mode_state";

    public static final int REQUEST_LOGIN = 0x01;
    public static final int RESULT_LOGIN = 0x10;
    public static final String EXTRA_LOGIN = "login";

    public static final String[] IMAGE_URLS = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527185657592&di=bfc591ab3e872ed7706b4fab9d14100e&imgtype=0&src=http%3A%2F%2Fimg008.hc360.cn%2Fm2%2FM02%2F5B%2F8E%2FwKhQcVQ7dCOEeWVwAAAAAC57UX8062.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527185742674&di=7bc05fb831a90845b08d8e6698582cc4&imgtype=0&src=http%3A%2F%2Fa.vpimg4.com%2Fupload%2Fmerchandise%2Fpdc%2F921%2F179%2F8390563877277179921%2F0%2F6921552600606-110_1.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527185795946&di=47d51258a285e2d74af459c71ed58425&imgtype=0&src=http%3A%2F%2Fimgqn.koudaitong.com%2Fupload_files%2F2014%2F12%2F10%2FFozxaVdlw3Yd4rFDobGZG3eutH_I.jpg%2521580x580.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527185849849&di=f8cb069ad7a12a1abc24c9cf1c83da1e&imgtype=0&src=http%3A%2F%2Fimages.youshang.com%2Fclub%2Fcms%2Fuploadfile%2F2010%2F1208%2F20101208102522281.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527780620&di=5c6b41fa829e5262f3e0cb56ba7f218c&imgtype=jpg&er=1&src=http%3A%2F%2Fd6.yihaodianimg.com%2FN00%2FM02%2F28%2FCC%2FCgMBmVN92AeAVHzsAANs160TcVw19700.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3526300963,2229521203&fm=27&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527780720&di=06ad60b0014850fd43efd8219ae98eaa&imgtype=jpg&er=1&src=http%3A%2F%2Fa.vpimg2.com%2Fupload%2Fmerchandise%2Fpdcvis%2F2016%2F12%2F22%2F155%2F5fd2c34b-082f-415a-ab59-c0e55d882eae.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2096765494,2266994991&fm=27&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186090042&di=1ef9515c915e1f631c987796a1ad8c17&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01410055448c8d0000019ae910f3dd.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186133381&di=0fc9d255d552a1e587b8478594a8a39a&imgtype=0&src=http%3A%2F%2Fpic44.nipic.com%2F20140707%2F4136797_233434321686_2.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186156715&di=50d774f5f3c98d54b257e6f6534bdca4&imgtype=0&src=http%3A%2F%2Fpic77.nipic.com%2Ffile%2F20150909%2F1754547_020245108026_2.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186188896&di=dafb9ec2a4f1b4fdc97af5570911390e&imgtype=0&src=http%3A%2F%2Fimg.91jm.com%2F2017%2F02%2F91yw747Zfajm.jpg"
    };

}
