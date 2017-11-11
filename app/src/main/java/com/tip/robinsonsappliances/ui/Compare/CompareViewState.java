package com.tip.robinsonsappliances.ui.Compare;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;



@SuppressWarnings("WeakerAccess")
public class CompareViewState implements RestorableViewState<CompareView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<CompareView> restoreInstanceState(Bundle in) {
        return this;
    }

    @Override
    public void apply(CompareView view, boolean retained) {

    }
}
