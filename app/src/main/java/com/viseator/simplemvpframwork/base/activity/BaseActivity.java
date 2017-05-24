package com.viseator.simplemvpframwork.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.viseator.simplemvpframwork.R;
import com.viseator.simplemvpframwork.base.data.source.BaseDataRepository;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class BaseActivity extends FragmentActivity{
    private BaseContract.Presenter mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseFragment baseFragment = new BaseFragment();
        mPresenter = new BasePresenter(BaseDataRepository.getInstance(null,null),baseFragment);

        //// TODO: 5/25/17  

    }
}
