package com.joker.example.home.banner;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public class HomePresenter_Banner implements HomeContract_Banner.Presenter {
    private final HomeContract_Banner.View mBannerView;

    public HomePresenter_Banner(@NonNull HomeContract_Banner.View loginView){
        mBannerView = checkNotNull(loginView, "loginView be null!");

        mBannerView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public List<String> getBanners() {
        String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
                "http://img2.3lian.com/2014/f2/37/d/40.jpg",
                "http://d.3987.com/sqmy_131219/001.jpg",
                "http://img2.3lian.com/2014/f2/37/d/39.jpg",
                "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
                "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
                "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
        };
        return Arrays.asList(images);
    }
}
