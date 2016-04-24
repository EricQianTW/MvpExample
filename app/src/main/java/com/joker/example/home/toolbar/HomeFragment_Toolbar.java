package com.joker.example.home.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joker.example.R;
import com.joker.example.base.BaseFragment;
import com.joker.example.bean.IconInfo;
import com.joker.example.components.pacificadapter.HorizontalItemDecoration;
import com.joker.example.components.pacificadapter.VerticalItemDecoration;
import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public class HomeFragment_ToolBar extends BaseFragment implements HomeContract_ToolBar.View {
    private HomeContract_ToolBar.Presenter mPresenter;
    private RecyclerView recyclerView;
    private RecyclerAdapter<IconInfo> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frg_toolbar, container, false);
        ButterKnife.bind(this, view);

        try {
            initViews(view);

            // 让Fragment中的onCreateOptionsMenu生效必须先调用setHasOptionsMenu方法
            setHasOptionsMenu(true);
            // 在 Activity 重绘时，Fragment 不会被重复绘制，也就是它会被“保留”
            setRetainInstance(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public HomeFragment_ToolBar(){

    }

    public static HomeFragment_ToolBar newInstance() {
        return new HomeFragment_ToolBar();
    }

    @Override
    public void setPresenter(HomeContract_ToolBar.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    private void initViews(View view) throws Exception {

    }

}
