package com.tip.robinsonsappliances.ui.Appliances.list;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;



@SuppressWarnings("WeakerAccess")
public class AppliancesListViewState implements RestorableViewState<AppliancesListView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<AppliancesListView> restoreInstanceState(Bundle in) {
        return this;
    }

    @Override
    public void apply(AppliancesListView view, boolean retained) {

    }
}
