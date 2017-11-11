package com.tip.robinsonsappliances.ui.Store;


import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tip.robinsonsappliances.models.data.Stores;

import java.util.List;


@SuppressWarnings("WeakerAccess")
public interface StoreView extends MvpView {

    void setStores(List<Stores> stores);

}
