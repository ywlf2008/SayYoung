package com.yw.sayyoung.sayyoung.core.db;

import com.yw.sayyoung.sayyoung.core.dao.HistoryData;

import java.util.List;

/**
 * @author quchao
 * @date 2017/11/27
 */

public interface DbHelper {

    /**
     * 增加历史数据
     *
     * @param data  added string
     * @return  List<HistoryData>
     */
    List<HistoryData> addHistoryData(String data);

    /**
     * Clear search history data
     */
    void clearHistoryData();

    /**
     * Load all history data
     *
     * @return List<HistoryData>
     */
    List<HistoryData> loadAllHistoryData();

}
