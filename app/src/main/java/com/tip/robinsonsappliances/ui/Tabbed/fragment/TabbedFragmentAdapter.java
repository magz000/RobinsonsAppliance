package com.tip.robinsonsappliances.ui.Tabbed.fragment;

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
import com.tip.robinsonsappliances.databinding.ItemTabbedFragmentBinding;
import com.tip.robinsonsappliances.models.data.Appliances;

import java.util.ArrayList;
import java.util.List;



public class TabbedFragmentAdapter extends RecyclerView.Adapter<TabbedFragmentAdapter.ViewHolder> {

    private List<Appliances> appliances;
    private TabbedFragmentView view;

    Context context;

    int lastPosition = -1;

    public TabbedFragmentAdapter(TabbedFragmentView view, Context context) {
        appliances = new ArrayList<>();
        this.view = view;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTabbedFragmentBinding itemTabbedFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_tabbed_fragment, parent, false);
        return new ViewHolder(itemTabbedFragmentBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTabbedFragmentBinding.setAppliances(appliances.get(position));
        holder.itemTabbedFragmentBinding.setView(view);

        Glide.with(context).load(Constants.IMAGELINK + appliances.get(position).getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.itemTabbedFragmentBinding.productImage);
        holder.itemTabbedFragmentBinding.productName.setText(appliances.get(position).getName());


        int perc = (int)((appliances.get(position).getPrice()-appliances.get(position).getActualPrice())/appliances.get(position).getPrice() * 100);


        //if(appliances.get(position).getActualPrice() != 0){

        if(appliances.get(position).getActualPrice() <  appliances.get(position).getPrice()){



            holder.itemTabbedFragmentBinding.percDiscount.setText(perc + "% OFF");
            holder.itemTabbedFragmentBinding.percDiscount.setVisibility(View.VISIBLE);

            holder.itemTabbedFragmentBinding.previousPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));
            holder.itemTabbedFragmentBinding.productPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getActualPrice()));

        }else{
            holder.itemTabbedFragmentBinding.percDiscount.setVisibility(View.GONE);
            holder.itemTabbedFragmentBinding.previousPrice.setVisibility(View.GONE);
            holder.itemTabbedFragmentBinding.productPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getPrice()));
        }

        holder.itemTabbedFragmentBinding.previousPrice.setPaintFlags(holder.itemTabbedFragmentBinding.previousPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

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
        private ItemTabbedFragmentBinding itemTabbedFragmentBinding;

        public ViewHolder(ItemTabbedFragmentBinding itemTabbedFragmentBinding) {
            super(itemTabbedFragmentBinding.getRoot());
            this.itemTabbedFragmentBinding = itemTabbedFragmentBinding;
        }
    }
}
