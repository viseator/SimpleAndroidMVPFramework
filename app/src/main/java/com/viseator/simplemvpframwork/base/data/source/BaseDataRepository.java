package com.viseator.simplemvpframwork.base.data.source;

import com.viseator.simplemvpframwork.base.data.BaseDataModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

/**
 * Concrete implementation to load tasks from the data sources into a cache.
 */

public class BaseDataRepository implements BaseDataSource {
    private static BaseDataRepository INSTANCE = null;
    private final BaseDataSource mLocalDataSource;
    private final BaseDataSource mRemoteDataSource;

    Map<String, BaseDataModel> mCachedData;

    private BaseDataRepository(BaseDataSource mLocalDataSource,
                               BaseDataSource mRemoteDataSource) {
        this.mLocalDataSource = mLocalDataSource;
        this.mRemoteDataSource = mRemoteDataSource;
    }

    public static BaseDataRepository getInstance(BaseDataSource mLocalDataSource,
                                                 BaseDataSource mRemoteDataSource) {
        if(INSTANCE == null){
            INSTANCE = new BaseDataRepository(mLocalDataSource, mRemoteDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getDataList(final LoadDataListCallBack callback) {
        mLocalDataSource.getDataList(new LoadDataListCallBack() {
            @Override
            public void onDataListLoaded(List<BaseDataModel> data) {
                refreshCache(data);
                callback.onDataListLoaded(new ArrayList<>(mCachedData.values()));
            }

            @Override
            public void onDataListNotAvailable() {

            }
        });
    }

    @Override
    public void getData(String dataId, GetDataCallBack callback) {

    }

    @Override
    public void saveData(BaseDataModel data) {

    }

    @Override
    public void addData(BaseDataModel data) {
    }

    @Override
    public void refreshDataList() {

    }

    @Override
    public void deleteData(String dataId) {

    }

    @Override
    public void deleteAllData() {

    }
    private void refreshCache(List<BaseDataModel> dataList) {
        if(mCachedData == null){
            mCachedData = new LinkedHashMap<>();
        }
        mCachedData.clear();
        for (BaseDataModel data : dataList) {
            mCachedData.put(data.getId(),data);
        }
    }
}
