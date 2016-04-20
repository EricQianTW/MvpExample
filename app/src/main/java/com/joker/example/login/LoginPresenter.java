package com.joker.example.login;

import android.support.annotation.NonNull;

import com.joker.example.utils.IntentUtils;
import com.joker.example.utils.L;
import com.joker.example.utils.SPUtils;
import com.joker.example.utils.T;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;

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
    public void loginTask() {
        mLoginView.loginSuccess();
    }

    public void okHttp() {
//        OkHttpUtils
//                .get()
//                .url(Constant.HTTP_IP)
//                .addParams("_Interface", "Matan.User_1")
//                .addParams("_Method", "MBUserLogin")
//                .addParams("deviceid", "123")
//                .addParams("loginname", GSONUtils.toJson(account.getText().toString()))
//                .addParams("password", GSONUtils.toJson(password.getText().toString()))
//                .build()//
//                .execute(new Callback<EmployeeInfo>() {
//                    @Override
//                    public EmployeeInfo parseNetworkResponse(Response response) throws Exception {
//                        return GSONUtils.fromJson(response.body().string(), EmployeeInfo.class);
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e) {
//                        showProgress(false, loginProgress, loginForm);
//                        L.e(TAG, e.toString());
//                    }
//
//                    @Override
//                    public void onResponse(EmployeeInfo response) {
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
//                    }
//                });
    }

    @Override
    public void start() {

    }
}
