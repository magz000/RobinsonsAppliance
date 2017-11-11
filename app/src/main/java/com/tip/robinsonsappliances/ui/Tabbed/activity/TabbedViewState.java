package com.tip.robinsonsappliances.ui.Tabbed.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.tip.robinsonsappliances.ui.Tabbed.fragment.TabbedFragmentView;


@SuppressWarnings("WeakerAccess")
public class TabbedViewState implements RestorableViewState<TabbedView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<TabbedView> restoreInstanceState(Bundle in) {
        return this;
    }

    @Override
    public void apply(TabbedView view, boolean retained) {

    }
}
