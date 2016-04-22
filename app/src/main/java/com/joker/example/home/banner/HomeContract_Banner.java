package com.joker.example.home.banner;

import com.joker.example.base.BaseInterfacePresenter;
import com.joker.example.base.BaseInterfaceView;

import java.util.List;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public interface HomeContract_Banner{

    interface View extends BaseInterfaceView<Presenter> {

    }

    interface Presenter extends BaseInterfacePresenter {
        List<String> getBanners();
    }
}
