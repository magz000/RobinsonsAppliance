package com.tip.robinsonsappliances.ui.Appliances.details.fragment;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tip.robinsonsappliances.models.data.Appliances;


@SuppressWarnings("WeakerAccess")
public interface FragmentAppliancesDetailView extends MvpView {
    void setAppliances(Appliances appliances);
}
