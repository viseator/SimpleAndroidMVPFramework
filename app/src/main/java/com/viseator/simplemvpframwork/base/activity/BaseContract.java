package com.viseator.simplemvpframwork.base.activity;

import android.content.Intent;

import com.viseator.simplemvpframwork.base.BasePresenterInterface;
import com.viseator.simplemvpframwork.base.BaseViewInterface;
import com.viseator.simplemvpframwork.base.data.BaseDataModel;

import java.util.List;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

/**
 * Declare the method should be implemented by view and presenter
 */
public class BaseContract {
    interface Presenter extends BasePresenterInterface {
        //Those method can also be put into the BasePresenterInterface if required
        void loadData();
        void result(int requestCode, int resultCode,Intent data);
        void addNewData(BaseDataModel data);
    }

    interface View extends BaseViewInterface<Presenter> {
        //Those method can also be put into the BaseViewInterface if required
        void showData(List<BaseDataModel> data);
        void showMessage(String message);

    }
}
