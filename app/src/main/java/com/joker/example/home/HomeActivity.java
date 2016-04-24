package com.joker.example.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import com.joker.example.R;
import com.joker.example.base.BaseAppCompatActivity;
import com.joker.example.home.banner.HomeFragment_Banner;
import com.joker.example.home.banner.HomePresenter_Banner;
import com.joker.example.home.icon.HomeFragment_Icon;
import com.joker.example.home.icon.HomePresenter_Icon;
import com.joker.example.home.recommendgoods.HomeFragment_RecommendGoods;
import com.joker.example.home.recommendgoods.HomePresenter_RecommendGoods;
import com.joker.example.home.toolbar.HomeFragment_ToolBar;
import com.joker.example.home.toolbar.HomePresenter_ToolBar;
import com.joker.example.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by eric_qiantw on 16/4/21.
 */
public class HomeActivity extends BaseAppCompatActivity {
    @Bind(R.id.sf_home)
    SwipeRefreshLayout sfHome;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<Integer> fragmentIds = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);

        initNavigation(R.id.bn_home);

        initFragment();

        initAction();
    }

    private void initFragment() {
        HomeFragment_ToolBar toolBarFragment = (HomeFragment_ToolBar) getSupportFragmentManager().findFragmentById(R.id.toolBarFrame);
        HomeFragment_Banner bannerFragment = (HomeFragment_Banner) getSupportFragmentManager().findFragmentById(R.id.bannerFrame);
        HomeFragment_Icon iconFragment = (HomeFragment_Icon) getSupportFragmentManager().findFragmentById(R.id.iconFrame);
        HomeFragment_RecommendGoods recommendGoodsFragment = (HomeFragment_RecommendGoods) getSupportFragmentManager().findFragmentById(R.id.recommendGoodsFrame);

        if (toolBarFragment == null) {
            toolBarFragment = HomeFragment_ToolBar.newInstance();
        }

        if (bannerFragment == null) {
            bannerFragment = HomeFragment_Banner.newInstance();
        }

        if (iconFragment == null) {
            iconFragment = HomeFragment_Icon.newInstance();
        }

        if (recommendGoodsFragment == null) {
            recommendGoodsFragment = HomeFragment_RecommendGoods.newInstance();
        }

        // 工具栏fragment
        fragments.add(toolBarFragment);
        fragmentIds.add(R.id.toolBarFrame);

        // 轮播图fragment
        fragments.add(bannerFragment);
        fragmentIds.add(R.id.bannerFrame);

        // 图标fragment
        fragments.add(iconFragment);
        fragmentIds.add(R.id.iconFrame);

        // 推荐商品fragment
        fragments.add(recommendGoodsFragment);
        fragmentIds.add(R.id.recommendGoodsFrame);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragments, fragmentIds);

        new HomePresenter_ToolBar(toolBarFragment);
        new HomePresenter_Banner(bannerFragment);
        new HomePresenter_Icon(iconFragment);
        new HomePresenter_RecommendGoods(recommendGoodsFragment);
    }

    private void initAction(){
        sfHome.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        sfHome.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }
}
