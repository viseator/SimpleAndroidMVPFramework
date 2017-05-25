package com.viseator.simplemvpframwork.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.viseator.simplemvpframwork.base.data.source.BaseDataRepository;
import com.viseator.simplemvpframwork.base.data.source.local.LocalDataSource;
import com.viseator.simplemvpframwork.base.data.source.remote.RemoteDataSource;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class BaseActivity extends FragmentActivity {
    private BaseContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Just for demo
        BaseFragment baseFragment = new BaseFragment();
        //Connect data repository with fragment, and set the presenter to fragment
        mPresenter = new BasePresenter(BaseDataRepository.getInstance(new LocalDataSource(),
                new RemoteDataSource()), baseFragment);


    }
}
