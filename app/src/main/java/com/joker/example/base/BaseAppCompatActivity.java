package com.joker.example.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.joker.example.BuildConfig;
import com.joker.example.R;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by eric_qiantw on 16/4/20.
 */
public class BaseAppCompatActivity extends AppCompatActivity {
    // 当前class名
    protected String TAG = this.getClass().getName();
//    // 画面底部导航栏
//    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.initialize(
                Settings.getInstance()
                        .isShowMethodLink(true)
                        .isShowThreadInfo(false)
                        .setMethodOffset(0)
                        .setLogPriority(BuildConfig.DEBUG ? Log.VERBOSE : Log.ASSERT)
        );

    }

    protected void initNavigation(int navResId) {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(navResId);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_recents, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorites, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.ic_nearby, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.ic_friends, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.drawable.ic_restaurants, "Games"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
    }

//    protected void initBottomBar(Bundle savedInstanceState,int rootLayoutId,int scrollLayoutId) {
//        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(rootLayoutId),
//                findViewById(scrollLayoutId), savedInstanceState);
//
//        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
//            @Override
//            public void onMenuTabSelected(@IdRes int menuItemId) {
////                mMessageView.setText(getMessage(menuItemId, false));
//            }
//
//            @Override
//            public void onMenuTabReSelected(@IdRes int menuItemId) {
////                Toast.makeText(getApplicationContext(), getMessage(menuItemId, true), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
//            @Override
//            public void onTabSelected(int position) {
//
//            }
//
//            @Override
//            public void onTabReSelected(int position) {
//
//            }
//        });
//
//        mBottomBar.mapColorForTab(0, "#7B1FA2");
//        mBottomBar.mapColorForTab(1, "#7B1FA2");
//        mBottomBar.mapColorForTab(2, "#7B1FA2");
//        mBottomBar.mapColorForTab(3, "#7B1FA2");
//        mBottomBar.mapColorForTab(4, "#7B1FA2");
//
////        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
////        mBottomBar.mapColorForTab(1, 0xFF5D4037);
////        mBottomBar.mapColorForTab(2, "#7B1FA2");
////        mBottomBar.mapColorForTab(3, "#FF5252");
////        mBottomBar.mapColorForTab(4, "#FF9800");
//    }

    /**
     * 取得当前Activity的弱引用
     * @return
     */
    public static Activity getActivity() {
        Class activityThreadClass = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            activitiesField.setAccessible(true);
            Map activities = (Map) activitiesField.get(activityThread);
            for (Object activityRecord : activities.values()) {
                Class activityRecordClass = activityRecord.getClass();
                Field pausedField = activityRecordClass.getDeclaredField("paused");
                pausedField.setAccessible(true);
                if (!pausedField.getBoolean(activityRecord)) {
                    Field activityField = activityRecordClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    Activity activity = (Activity) activityField.get(activityRecord);
                    return activity;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
