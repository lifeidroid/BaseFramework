package com.lifei.framework.activity;

import android.view.View;
import android.widget.Button;

import com.lifei.framework.R;
import com.lifei.framework.views.ToastMaker;

import org.xutils.view.annotation.ViewInject;


public class MainActivity extends BaseActivity {
    @ViewInject(R.id.btn_Hellow)
    Button btnHellow;

    @Override
    protected void initListeners() {
        btnHellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastMaker.showShortToast("您点击了按钮");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {
        btnHellow.setText("按钮。。");
    }
}
