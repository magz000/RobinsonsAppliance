package com.tip.robinsonsappliances.ui.Tabbed.fragment;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tip.robinsonsappliances.models.data.Appliances;

import java.util.List;



@SuppressWarnings("WeakerAccess")
public interface TabbedFragmentView extends MvpView {
    void setAppliances(List<Appliances> appliances);

    void stopLoading();

    void showMessage(String message);

    void onApplianceClicked(Appliances appliances);
}
