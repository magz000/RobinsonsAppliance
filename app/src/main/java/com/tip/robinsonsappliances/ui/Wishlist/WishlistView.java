package com.tip.robinsonsappliances.ui.Wishlist;


import com.hannesdorfmann.mosby.mvp.MvpView;
import com.tip.robinsonsappliances.models.data.Wishlist;

import java.util.List;


@SuppressWarnings("WeakerAccess")
public interface WishlistView extends MvpView {

    void setAppliance(List<Wishlist> appliances);

}
