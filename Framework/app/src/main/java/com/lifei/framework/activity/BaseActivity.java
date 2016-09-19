package com.lifei.framework.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lifei.framework.utils.ActivityStack;

import org.xutils.x;

/**
 * Created by lifei on 2016/9/10.
 */

public abstract class BaseActivity extends FragmentActivity {

    private boolean isCreate = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStack.getInstance().addActivity(this);
        setContentView(getLayoutId());
        x.view().inject(this);
        initParams();
        initListeners();
        isCreate = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isCreate) {
            isCreate = false;
            initParams();
        }
    }

    /**
     * 初始化事件监听
     */
    protected abstract void initListeners();

    /**
     * 初始化布局
     *
     * @author blue
     */
    protected abstract int getLayoutId();

    /**
     * 参数设置
     *
     * @author blue
     */
    protected abstract void initParams();

    @Override
    protected void onDestroy() {
        ActivityStack.getInstance().removeActivity(this);
        super.onDestroy();
    }
}
