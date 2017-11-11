package com.tip.robinsonsappliances.ui.Appliances.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.app.Utils;
import com.tip.robinsonsappliances.databinding.ItemApplianceBinding;
import com.tip.robinsonsappliances.models.data.Appliances;

import java.util.ArrayList;
import java.util.List;


public class AppliancesListAdapter extends RecyclerView.Adapter<AppliancesListAdapter.ViewHolder> {

    private List<Appliances> appliances;
    private AppliancesListView view;

    Context context;

    int lastPosition = -1;

    public AppliancesListAdapter(AppliancesListView view, Context context) {
        appliances = new ArrayList<>();
        this.view = view;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemApplianceBinding itemApplianceBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_appliance, parent, false);
        return new ViewHolder(itemApplianceBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemApplianceBinding.setAppliances(appliances.get(position));
        holder.itemApplianceBinding.setView(view);

        Glide.with(context).load(Constants.IMAGELINK + appliances.get(position).getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.itemApplianceBinding.productImage);
        holder.itemApplianceBinding.productName.setText(appliances.get(position).getName());
        holder.itemApplianceBinding.productPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));

    }

    @Override
    public int getItemCount() {
        return appliances.size();
    }

    public void setAppliances(List<Appliances> received) {
        this.appliances.clear();
        this.appliances.addAll(received);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemApplianceBinding itemApplianceBinding;

        public ViewHolder(ItemApplianceBinding itemApplianceBinding) {
            super(itemApplianceBinding.getRoot());
            this.itemApplianceBinding = itemApplianceBinding;
        }
    }
}
