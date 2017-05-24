package com.viseator.simplemvpframwork.base.data.source;

import com.viseator.simplemvpframwork.base.data.BaseDataModel;

import java.util.List;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

/**
 * Main entry point for accessing data.
 *
 * All data source should implement these methods to manage data stored in either local or remote.
 */
public interface BaseDataSource {
    interface LoadDataListCallBack {
        void onDataListLoaded(List<BaseDataModel> data);

        void onDataListNotAvailable();
    }

    interface GetDataCallBack {
        void onDataLoaded(BaseDataModel data);

        void onDataNotAvailable();
    }

    void getDataList(LoadDataListCallBack callback);

    void getData(String dataId, GetDataCallBack callback);

    void saveData(BaseDataModel data);
    void addData(BaseDataModel data);

    void refreshDataList();

    void deleteData(String dataId);

    void deleteAllData();
}
