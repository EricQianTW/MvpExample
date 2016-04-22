package com.joker.example.home;

import android.os.Bundle;

import com.joker.example.R;
import com.joker.example.base.BaseAppCompatActivity;
import com.joker.example.home.banner.HomeFragment_Banner;
import com.joker.example.home.banner.HomePresenter_Banner;
import com.joker.example.utils.ActivityUtils;

/**
 * Created by eric_qiantw on 16/4/21.
 */
public class HomeActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);

        HomeFragment_Banner bannerFragment = (HomeFragment_Banner) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        String taskId = null;
        if (bannerFragment == null) {
            bannerFragment = HomeFragment_Banner.newInstance();

//            if (getIntent().hasExtra(LoginFragment.ARGUMENT_EDIT_TASK_ID)) {
//                taskId = getIntent().getStringExtra(
//                        AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID);
//                actionBar.setTitle(R.string.edit_task);
//                Bundle bundle = new Bundle();
//                bundle.putString(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID, taskId);
//                loginFragment.setArguments(bundle);
//            } else {
//                actionBar.setTitle(R.string.add_task);
//            }

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    bannerFragment, R.id.contentFrame);
        }

        // Create the presenter
        new HomePresenter_Banner(bannerFragment);
    }
}
