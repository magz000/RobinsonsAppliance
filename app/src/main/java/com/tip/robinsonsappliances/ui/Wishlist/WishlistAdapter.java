package com.tip.robinsonsappliances.ui.Wishlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.app.Utils;
import com.tip.robinsonsappliances.databinding.ItemWishlistBinding;
import com.tip.robinsonsappliances.models.data.Wishlist;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    private List<Wishlist> appliances;
    private WishlistView view;

    private Context context;

    public WishlistAdapter(WishlistView view, Context context) {
        appliances = new ArrayList<>();
        this.view = view;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWishlistBinding itemWishlistBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_wishlist, parent, false);
        return new ViewHolder(itemWishlistBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.itemWishlistBinding.name.setText(appliances.get(position).getAppliances().getName());
        //holder.itemWishlistBinding.price.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getPrice()));
        holder.itemWishlistBinding.specs.setText(appliances.get(position).getAppliances().getSpecs());

        int perc = (int)((appliances.get(position).getAppliances().getPrice()-appliances.get(position).getAppliances().getActualPrice())/appliances.get(position).getAppliances().getPrice() * 100);



        if((appliances.get(position).getAppliances().getActualPrice() <  appliances.get(position).getAppliances().getPrice())){

            holder.itemWishlistBinding.price.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getPrice()));
            holder.itemWishlistBinding.actualPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getActualPrice()));
            holder.itemWishlistBinding.price.setVisibility(View.VISIBLE);

            holder.itemWishlistBinding.percDiscount.setText(perc + "% OFF");
            holder.itemWishlistBinding.percDiscount.setVisibility(View.VISIBLE);

        }else{
            holder.itemWishlistBinding.actualPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getActualPrice()));
            holder.itemWishlistBinding.price.setVisibility(View.GONE);
            holder.itemWishlistBinding.percDiscount.setVisibility(View.GONE);
        }

        holder.itemWishlistBinding.price.setPaintFlags(holder.itemWishlistBinding.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(context).load(Constants.IMAGELINK + appliances.get(position).getAppliances().getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.itemWishlistBinding.productImage);

        holder.itemWishlistBinding.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();

                realm.beginTransaction();

                Wishlist wl = realm.where(Wishlist.class)
                        .equalTo("appliances.id", appliances.get(position).getAppliances().getId())
                        .findFirst();

                wl.deleteFromRealm();

                realm.commitTransaction();

                notifyDataSetChanged();
                appliances.remove(appliances.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return appliances.size();
    }

    public void setAppliances(List<Wishlist> appliances) {
        this.appliances.clear();
        this.appliances.addAll(appliances);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemWishlistBinding itemWishlistBinding;

        public ViewHolder(ItemWishlistBinding itemWishlistBinding) {
            super(itemWishlistBinding.getRoot());
            this.itemWishlistBinding = itemWishlistBinding;
        }
    }
}
