package com.joker.example.login;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.joker.example.BuildConfig;
import com.joker.example.R;
import com.joker.example.base.BaseAppCompatActivity;
import com.joker.example.utils.ActivityUtils;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        String taskId = null;
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();

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
                    loginFragment, R.id.contentFrame);
        }

        // Create the presenter
        new LoginPresenter(loginFragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

