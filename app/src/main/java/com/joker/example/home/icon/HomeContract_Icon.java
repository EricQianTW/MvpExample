package com.joker.example.home.icon;

import com.joker.example.base.BaseInterfacePresenter;
import com.joker.example.base.BaseInterfaceView;
import com.joker.example.bean.IconInfo;

import java.util.List;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public interface HomeContract_Icon {

    interface View extends BaseInterfaceView<Presenter> {

    }

    interface Presenter extends BaseInterfacePresenter {
        List<IconInfo> getIcons();
    }
}
