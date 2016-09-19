package com.lifei.framework.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;


/**
 * Fragment基类
 * Created by lifei on 2016/9/10.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        x.view().inject(this, view);
        initParams();
        initListeners();
        return view;
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

}
