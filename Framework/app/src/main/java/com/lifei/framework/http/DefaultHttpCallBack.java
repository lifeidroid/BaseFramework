package com.lifei.framework.http;

/**
 * Created by lifei on 2016/9/11.
 */

public interface DefaultHttpCallBack {
    public void onSuccess(String result);

    public void onError(int code, String error);
}
