package com.tip.robinsonsappliances.ui.Appliances.details;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tip.robinsonsappliances.models.data.Appliances;

import java.util.List;


@SuppressWarnings("WeakerAccess")
public interface AppliancesDetailView extends MvpView {
    void setAppliances(List<Appliances> appliances);
}
