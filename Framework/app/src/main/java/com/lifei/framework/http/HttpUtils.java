package com.lifei.framework.http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifei on 2016/9/11.
 */

public class HttpUtils {
    /**
     * Get网络请求
     *
     * @param url
     * @param map
     * @param httpCallBack
     * @return
     */
    public Callback.Cancelable doGet(String url, HashMap<String, String> map, final DefaultHttpCallBack httpCallBack) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (null != httpCallBack) {
                    httpCallBack.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (null != httpCallBack) {
                    httpCallBack.onError(400, "网络错误！");
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
        return cancelable;
    }

    /**
     * Post网络请求
     *
     * @param url
     * @param map
     * @param httpCallBack
     * @return
     */
    public Callback.Cancelable doPost(String url, HashMap<String, String> map, final DefaultHttpCallBack httpCallBack) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (null != httpCallBack) {
                    httpCallBack.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (null != httpCallBack) {
                    httpCallBack.onError(400, "网络错误！");
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
        return cancelable;
    }

    /**
     * 表单文件上传
     * @param url
     * @param map       常量参数
     * @param fileMap   文件参数
     * @param httpCallBack
     * @return
     */
    public Callback.Cancelable doUpload(String url, HashMap<String, String> map, HashMap<String, Object> fileMap, final DefaultHttpCallBack httpCallBack) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
        if (null != fileMap) {
            for (Map.Entry<String, Object> entry : fileMap.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue(), null);
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (null != httpCallBack) {
                    httpCallBack.onSuccess(result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (null != httpCallBack) {
                    httpCallBack.onError(400, "网络错误！");
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
        return cancelable;
    }

//    public Callback.Cancelable doDownload(String url,String path){
//        RequestParams params = new RequestParams(url);
//    }
}
