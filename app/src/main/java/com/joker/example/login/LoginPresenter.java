package com.joker.example.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.joker.example.bean.UserInfo;
import com.joker.example.constant.Constant;
import com.joker.example.utils.GSONUtils;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/20.
 */
public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View mLoginView;

    public LoginPresenter(@NonNull LoginContract.View loginView){
        mLoginView = checkNotNull(loginView, "loginView be null!");

        mLoginView.setPresenter(this);
    }
    @Override
    public void loginTask(String userId,String passwd) {
        okHttp(userId,passwd);
    }

    public void okHttp(String userId,String passwd) {
        OkHttpUtils
                .get()
                .url(Constant.HTTP_IP)
                .addParams("_Interface", "Matan.User_1")
                .addParams("_Method", "MBUserLogin")
                .addParams("deviceid", "123")
                .addParams("loginname", GSONUtils.toJson(userId))
                .addParams("password", GSONUtils.toJson(passwd))
                .build()//
                .execute(new Callback<UserInfo>() {
                    @Override
                    public UserInfo parseNetworkResponse(Response response) throws Exception {
                        return GSONUtils.fromJson(response.body().string(), UserInfo.class);
                    }

                    @Override
                    public void onError(okhttp3.Call call, Exception e) {
                        mLoginView.loginFaild();
                        Logger.e(e,"something happend");
                    }

                    @Override
                    public void onResponse(UserInfo response) {
                        mLoginView.loginSuccess();
//                        showProgress(false, loginProgress, loginForm);
//                        if(response.getState() == Constant.OKHTTP_RESULT_SUCESS){
//                            T.showShort(getActivity(), "登录成功");
//                            EmployeeInfo info = new EmployeeInfo();
//                            response.setLogin(true);
//                            SPUtils.put(getActivity(), SPUtils.SP_LOGIN_INFO,GSONUtils.toJson(response));
//
//                            IntentUtils.startActivityWithFinish(getActivity(), OrderGoodsActivity.class);
//                        }else{
//                            T.showShort(getActivity(),response.getCustomMessage());
//                        }
                    }
                });
    }

    @Override
    public void start() {

    }
}
