package com.joker.example.login;

import com.joker.example.base.BasePresenter;
import com.joker.example.base.BaseView;

/**
 * Created by eric_qiantw on 16/4/20.
 */
public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginSuccess();
    }

    interface Presenter extends BasePresenter {
        void loginTask();
    }
}
