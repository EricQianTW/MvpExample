package com.joker.example.home;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.joker.example.R;
import com.joker.example.base.BaseAppCompatActivity;
import com.joker.example.home.banner.HomeFragment_Banner;
import com.joker.example.home.banner.HomePresenter_Banner;
import com.joker.example.home.icon.HomeFragment_Icon;
import com.joker.example.home.icon.HomePresenter_Icon;
import com.joker.example.utils.ActivityUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric_qiantw on 16/4/21.
 */
public class HomeActivity extends BaseAppCompatActivity {
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);

//        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.cl_home),
                findViewById(R.id.ns_home), savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
//                mMessageView.setText(getMessage(menuItemId, false));
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
//                Toast.makeText(getApplicationContext(), getMessage(menuItemId, true), Toast.LENGTH_SHORT).show();
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
//        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
//        mBottomBar.mapColorForTab(1, 0xFF5D4037);
//        mBottomBar.mapColorForTab(2, "#7B1FA2");
//        mBottomBar.mapColorForTab(3, "#FF5252");
//        mBottomBar.mapColorForTab(4, "#FF9800");

        HomeFragment_Banner bannerFragment = (HomeFragment_Banner) getSupportFragmentManager().findFragmentById(R.id.bannerFrame);
        HomeFragment_Icon iconFragment = (HomeFragment_Icon) getSupportFragmentManager().findFragmentById(R.id.iconFrame);

        if(bannerFragment == null){
            bannerFragment = HomeFragment_Banner.newInstance();
        }

        if(iconFragment == null){
            iconFragment = HomeFragment_Icon.newInstance();
        }

        List<Fragment> fragments = new ArrayList<Fragment>();
        List<Integer> fragmentIds = new ArrayList<Integer>();

        fragments.add(bannerFragment);
        fragmentIds.add(R.id.bannerFrame);

        fragments.add(iconFragment);
        fragmentIds.add(R.id.iconFrame);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragments,fragmentIds);

        new HomePresenter_Banner(bannerFragment);
        new HomePresenter_Icon(iconFragment);
    }
}
