package com.viseator.simplemvpframwork.base.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.viseator.simplemvpframwork.base.data.BaseDataModel;

import java.util.List;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

/**
 * The concrete implement of view.
 * Handle the require by presenter and require presenter to access data.
 */
public class BaseFragment extends Fragment implements BaseContract.View {

    //use the methods provided by presenter to access the data.
    private BaseContract.Presenter mPresenter;

    public void setPresenter(BaseContract.Presenter presenter) {
       mPresenter = presenter;
    }

    @Override
    public void showData(List<BaseDataModel> data) {
        //use the data
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode,resultCode,data);
    }
}
