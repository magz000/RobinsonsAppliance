package com.tip.robinsonsappliances.ui.Compare;


import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tip.robinsonsappliances.models.data.ComparedAppliances;

import java.util.List;



@SuppressWarnings("WeakerAccess")
public interface CompareView extends MvpView {

    void setAppliance(List<ComparedAppliances> appliances);

}
