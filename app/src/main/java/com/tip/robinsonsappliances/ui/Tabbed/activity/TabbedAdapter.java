package com.tip.robinsonsappliances.ui.Tabbed.activity;

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
import com.tip.robinsonsappliances.databinding.ItemTabbedBinding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.ui.Tabbed.fragment.TabbedFragmentView;

import java.util.ArrayList;
import java.util.List;


public class TabbedAdapter extends RecyclerView.Adapter<TabbedAdapter.ViewHolder> {

    private List<Appliances> appliances;
    private TabbedView view;

    Context context;

    int lastPosition = -1;

    public TabbedAdapter(TabbedView view, Context context) {
        appliances = new ArrayList<>();
        this.view = view;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTabbedBinding itemTabbedBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_tabbed, parent, false);
        return new ViewHolder(itemTabbedBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTabbedBinding.setAppliances(appliances.get(position));
        holder.itemTabbedBinding.setView(view);

        Glide.with(context).load(Constants.IMAGELINK + appliances.get(position).getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.itemTabbedBinding.productImage);
        holder.itemTabbedBinding.productName.setText(appliances.get(position).getName());
        //holder.itemTabbedBinding.price.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));

        int perc = (int)((appliances.get(position).getPrice()-appliances.get(position).getActualPrice())/appliances.get(position).getPrice() * 100);


        //if(appliances.get(position).getActualPrice() != 0){

        if((appliances.get(position).getActualPrice() <  appliances.get(position).getPrice())){

            holder.itemTabbedBinding.price.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));
            holder.itemTabbedBinding.actualPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getActualPrice()));
            holder.itemTabbedBinding.price.setVisibility(View.VISIBLE);

            holder.itemTabbedBinding.percDiscount.setText(perc + "% OFF");
            holder.itemTabbedBinding.percDiscount.setVisibility(View.VISIBLE);

//                holder.itemTabbedFragmentBinding.previousPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));
//                holder.itemTabbedFragmentBinding.productPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getActualPrice()));

        }else{
            holder.itemTabbedBinding.actualPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getActualPrice()));
            holder.itemTabbedBinding.price.setVisibility(View.GONE);
            holder.itemTabbedBinding.percDiscount.setVisibility(View.GONE);
//                holder.itemTabbedFragmentBinding.previousPrice.setVisibility(View.GONE);
//                holder.itemTabbedFragmentBinding.productPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));
        }

        holder.itemTabbedBinding.price.setPaintFlags(holder.itemTabbedBinding.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


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
        private ItemTabbedBinding itemTabbedBinding;

        public ViewHolder(ItemTabbedBinding itemTabbedBinding) {
            super(itemTabbedBinding.getRoot());
            this.itemTabbedBinding = itemTabbedBinding;
        }
    }
}
