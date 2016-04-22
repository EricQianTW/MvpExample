package com.joker.example.home.recommendgoods;

import android.graphics.Color;
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
public class HomeFragment_RecommendGoods extends BaseFragment implements HomeContract_RecommendGoods.View {
    private HomeContract_RecommendGoods.Presenter mPresenter;
    private RecyclerView recyclerView;
    private RecyclerAdapter<IconInfo> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frg_icon, container, false);
        ButterKnife.bind(this, view);

        try {
            initAdapter();

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

    public HomeFragment_RecommendGoods(){

    }

    public static HomeFragment_RecommendGoods newInstance() {
        return new HomeFragment_RecommendGoods();
    }

    @Override
    public void setPresenter(HomeContract_RecommendGoods.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    private void initViews(View view) throws Exception {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_icon);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.addItemDecoration(new HorizontalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.red)
                .sizeResId(R.dimen.height_explore_divider_5)
                .build());
        recyclerView.addItemDecoration(new VerticalItemDecoration
                .Builder(getContext())
                .colorResId(R.color.red)
                .showLastDivider(false)
                .sizeResId(R.dimen.height_explore_divider_5)
                .build());
        recyclerView.setAdapter(adapter);
        adapter.replaceAll(mPresenter.getIcons());
    }

    private void initAdapter() {
        adapter = new RecyclerAdapter<IconInfo>(getContext(), R.layout.common_adp_siglepic) {
            @Override
            protected void convert(final RecyclerAdapterHelper helper, IconInfo info) {
                final int position = helper.getAdapterPosition();
                helper.setImageResource(R.id.iv_pic, info.getResId())
                        .getItemView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getItemView().setTag("hello world");
            }
        };
    }
}
