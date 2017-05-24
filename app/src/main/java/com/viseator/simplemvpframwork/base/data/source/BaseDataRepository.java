package com.viseator.simplemvpframwork.base.data.source;

import android.test.InstrumentationTestSuite;

import com.viseator.simplemvpframwork.base.data.BaseDataModel;

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
                               BaseDataRepository mRemoteDataSource) {
        this.mLocalDataSource = mLocalDataSource;
        this.mRemoteDataSource = mRemoteDataSource;
    }

    public static BaseDataRepository getInstance(BaseDataRepository mLocalDataSource,
                                                 BaseDataRepository mRemoteDataSource) {
        if(INSTANCE == null){
            INSTANCE = new BaseDataRepository(mLocalDataSource, mRemoteDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
    // TODO: 5/24/17

    @Override
    public void getDataList(LoadDataListCallBack callback) {

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
}
