package com.tip.robinsonsappliances.ui.Store;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;



@SuppressWarnings("WeakerAccess")
public class StoreViewState implements RestorableViewState<StoreView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<StoreView> restoreInstanceState(Bundle in) {
        return this;
    }

    @Override
    public void apply(StoreView view, boolean retained) {

    }
}
