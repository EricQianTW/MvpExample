package com.joker.example.home.recommendgoods;

import android.support.annotation.NonNull;

import com.joker.example.R;
import com.joker.example.bean.IconInfo;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public class HomePresenter_RecommendGoods implements HomeContract_RecommendGoods.Presenter {
    private final HomeContract_RecommendGoods.View mBannerView;

    public HomePresenter_RecommendGoods(@NonNull HomeContract_RecommendGoods.View loginView){
        mBannerView = checkNotNull(loginView, "loginView be null!");

        mBannerView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public List<IconInfo> getIcons() {
        List<IconInfo> list = new ArrayList<>();
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));
        list.add(new IconInfo(R.drawable.ic_default_adimage, "web work", "start：2016.01.01，end: 2016.02.01"));


        return list;
    }
}
