package com.joker.example.login;

import com.joker.example.base.BaseInterfacePresenter;
import com.joker.example.base.BaseInterfaceView;

/**
 * Created by eric_qiantw on 16/4/20.
 */
public interface LoginContract {
    interface View extends BaseInterfaceView<Presenter> {
        void loginSuccess();
        void loginFaild();
    }

    interface Presenter extends BaseInterfacePresenter {
        void loginTask(String userId,String passwd);
    }
}
