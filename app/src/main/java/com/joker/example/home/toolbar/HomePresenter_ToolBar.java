package com.joker.example.home.toolbar;

import android.support.annotation.NonNull;

import com.joker.example.R;
import com.joker.example.bean.IconInfo;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public class HomePresenter_ToolBar implements HomeContract_ToolBar.Presenter {
    private final HomeContract_ToolBar.View mBannerView;

    public HomePresenter_ToolBar(@NonNull HomeContract_ToolBar.View loginView){
        mBannerView = checkNotNull(loginView, "loginView be null!");

        mBannerView.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
