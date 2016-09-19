package com.lifei.framework.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by lifei on 2016/9/10.
 */

public class BaseApplication extends Application {
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initPlugins();
    }

    /**
     * 初始化插件
     */
    private void initPlugins() {
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        Fresco.initialize(this);
    }

    /**
     * 单例模式中获取唯一的MyApplication实例
     * @return
     */
    public static BaseApplication getInstance() {
        if (instance == null) {
            instance = new BaseApplication();
        }
        return instance;
    }
}
