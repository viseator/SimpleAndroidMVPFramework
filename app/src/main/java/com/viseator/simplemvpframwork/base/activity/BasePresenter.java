package com.viseator.simplemvpframwork.base.activity;

import com.viseator.simplemvpframwork.base.data.BaseDataModel;
import com.viseator.simplemvpframwork.base.data.source.BaseDataRepository;
import com.viseator.simplemvpframwork.base.data.source.BaseDataSource;

import java.util.List;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class BasePresenter implements BaseContract.Presenter {

    private final BaseDataRepository mDataRepository;
    private final BaseContract.View mView;
    public BasePresenter(BaseDataRepository dataRepository,BaseContract.View view) {
        mDataRepository = dataRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadData();
    }

    /**
     * Load data from repository, then invoke the corresponding method in mView to update UI.
     */
    @Override
    public void loadData() {
        mDataRepository.getDataList(new BaseDataSource.LoadDataListCallBack() {
            @Override
            public void onDataListLoaded(List<BaseDataModel> data) {
                mView.showData(data);
            }

            @Override
            public void onDataListNotAvailable() {
                mView.showMessage("DataNotAvailable");
            }
        });
    }


    /**
     * Add data to repository.
     */
    @Override
    public void addNewData(BaseDataModel data) {
        mDataRepository.addData(data);
        loadData();
    }
}
