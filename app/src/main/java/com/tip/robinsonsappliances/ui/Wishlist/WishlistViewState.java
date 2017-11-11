package com.tip.robinsonsappliances.ui.Wishlist;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;



@SuppressWarnings("WeakerAccess")
public class WishlistViewState implements RestorableViewState<WishlistView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<WishlistView> restoreInstanceState(Bundle in) {
        return this;
    }

    @Override
    public void apply(WishlistView view, boolean retained) {

    }
}
