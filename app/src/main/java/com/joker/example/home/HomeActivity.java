package com.joker.example.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.joker.example.R;
import com.joker.example.base.BaseAppCompatActivity;
import com.joker.example.home.banner.HomeFragment_Banner;
import com.joker.example.home.banner.HomePresenter_Banner;
import com.joker.example.home.icon.HomeFragment_Icon;
import com.joker.example.home.icon.HomePresenter_Icon;
import com.joker.example.home.recommendgoods.HomeFragment_RecommendGoods;
import com.joker.example.home.recommendgoods.HomePresenter_RecommendGoods;
import com.joker.example.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric_qiantw on 16/4/21.
 */
public class HomeActivity extends BaseAppCompatActivity {
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<Integer> fragmentIds = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);

        initNavigation(R.id.bn_home);

        HomeFragment_Banner bannerFragment = (HomeFragment_Banner) getSupportFragmentManager().findFragmentById(R.id.bannerFrame);
        HomeFragment_Icon iconFragment = (HomeFragment_Icon) getSupportFragmentManager().findFragmentById(R.id.iconFrame);
        HomeFragment_RecommendGoods recommendGoodsFragment = (HomeFragment_RecommendGoods) getSupportFragmentManager().findFragmentById(R.id.recommendGoodsFrame);

        if(bannerFragment == null){
            bannerFragment = HomeFragment_Banner.newInstance();
        }

        if(iconFragment == null){
            iconFragment = HomeFragment_Icon.newInstance();
        }

        if(recommendGoodsFragment == null){
            recommendGoodsFragment = HomeFragment_RecommendGoods.newInstance();
        }

        // 轮播图fragment
        fragments.add(bannerFragment);
        fragmentIds.add(R.id.bannerFrame);

        // 图标fragment
        fragments.add(iconFragment);
        fragmentIds.add(R.id.iconFrame);

        // 推荐商品fragment
        fragments.add(recommendGoodsFragment);
        fragmentIds.add(R.id.recommendGoodsFrame);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragments,fragmentIds);

        new HomePresenter_Banner(bannerFragment);
        new HomePresenter_Icon(iconFragment);
        new HomePresenter_RecommendGoods(recommendGoodsFragment);
    }
}
