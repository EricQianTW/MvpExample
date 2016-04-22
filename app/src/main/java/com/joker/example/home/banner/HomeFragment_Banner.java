package com.joker.example.home.banner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.joker.example.R;
import com.joker.example.base.BaseFragment;
import com.joker.example.components.convenientbanner.BannerUtils;
import com.joker.example.components.convenientbanner.NetworkImageHolderView;
import com.joker.example.utils.T;

import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public class HomeFragment_Banner extends BaseFragment implements HomeContract_Banner.View, ViewPager.OnPageChangeListener,OnItemClickListener {
    private HomeContract_Banner.Presenter mPresenter;
    private ConvenientBanner convenientBanner;
//    private ArrayList<Integer> localImages = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_frg_banner, container, false);
        ButterKnife.bind(this, view);

        try {
            initViews(view);
            init();

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

        initAction();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void initViews(View view) throws Exception {
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
    }

    private void init(){
        BannerUtils.initImageLoader(getActivity());

//        //本地图片例子
//        for (int position = 0; position < 7; position++)
//            localImages.add(ResourceUtils.getResId("ic_test_" + position, R.drawable.class));
//        convenientBanner.setPages(
//                new CBViewHolderCreator<LocalImageHolderView>() {
//                    @Override
//                    public LocalImageHolderView createHolder() {
//                        return new LocalImageHolderView();
//                    }
//                }, localImages)
//                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
//                //设置指示器的方向
////                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
////                .setOnPageChangeListener(this)//监听翻页事件
//                .setOnItemClickListener(this);

//        convenientBanner.setManualPageable(false);//设置不能手动影响

        //网络加载例子
//        networkImages= mPresenter.getBanners();
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, mPresenter.getBanners())
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setOnItemClickListener(this);



//手动New并且添加到ListView Header的例子
//        ConvenientBanner mConvenientBanner = new ConvenientBanner(this,false);
//        mConvenientBanner.setMinimumHeight(500);
//        mConvenientBanner.setPages(
//                new CBViewHolderCreator<LocalImageHolderView>() {
//                    @Override
//                    public LocalImageHolderView createHolder() {
//                        return new LocalImageHolderView();
//                    }
//                }, localImages)
//                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
//                        //设置指示器的方向
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
//                .setOnItemClickListener(this);
//        listView.addHeaderView(mConvenientBanner);
    }

    public HomeFragment_Banner(){

    }

    public static HomeFragment_Banner newInstance() {
        return new HomeFragment_Banner();
    }

    private void initAction(){

    }

    @Override
    public void setPresenter(HomeContract_Banner.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(int position) {
        T.showShort(getActivity(),"点击了第"+position+"个");
    }

}
