package com.tip.robinsonsappliances.ui.Appliances.details;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.databinding.ItemApplianceDetailsBinding;
import com.tip.robinsonsappliances.models.data.Appliances;

import java.util.List;



public class AppliancesDetailAdapter extends RecyclerView.Adapter<AppliancesDetailAdapter.ViewHolder> {

    private List<Appliances> appliances;

    Context context;


    public AppliancesDetailAdapter(List<Appliances> appliances, Context context) {
        this.appliances = appliances;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemApplianceDetailsBinding itemApplianceDetailsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_appliance_details, parent, false);
        return new ViewHolder(itemApplianceDetailsBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(Constants.IMAGELINK + appliances.get(position).getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.itemApplianceDetailsBinding.productImage);
        holder.itemApplianceDetailsBinding.name.setText(appliances.get(position).getName());
        holder.itemApplianceDetailsBinding.specs.setText(appliances.get(position).getSpecs());
        holder.itemApplianceDetailsBinding.price.setText("Php " + appliances.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return appliances.size();
    }

    public void setAppliances(List<Appliances> appliances) {
        this.appliances.clear();
        this.appliances.addAll(appliances);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemApplianceDetailsBinding itemApplianceDetailsBinding;

        public ViewHolder(ItemApplianceDetailsBinding itemApplianceDetailsBinding) {
            super(itemApplianceDetailsBinding.getRoot());
            this.itemApplianceDetailsBinding = itemApplianceDetailsBinding;
        }
    }
}
