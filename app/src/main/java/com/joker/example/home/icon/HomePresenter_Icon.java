package com.joker.example.home.icon;

import android.support.annotation.NonNull;

import com.joker.example.R;
import com.joker.example.bean.IconInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public class HomePresenter_Icon implements HomeContract_Icon.Presenter {
    private final HomeContract_Icon.View mBannerView;

    public HomePresenter_Icon(@NonNull HomeContract_Icon.View loginView){
        mBannerView = checkNotNull(loginView, "loginView be null!");

        mBannerView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public List<IconInfo> getIcons() {
        List<IconInfo> list = new ArrayList<>();
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.web, "web work", "start：2016.01.01，end: 2016.02.01"));


        return list;
    }
}
