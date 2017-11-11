package com.tip.robinsonsappliances.ui.Compare;

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
import com.tip.robinsonsappliances.databinding.ItemCompareBinding;
import com.tip.robinsonsappliances.models.data.ComparedAppliances;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class CompareAdapter extends RecyclerView.Adapter<CompareAdapter.ViewHolder> {

    private List<ComparedAppliances> appliances;
    private CompareView view;

    private Context context;

    public CompareAdapter(CompareView view, Context context) {
        appliances = new ArrayList<>();
        this.view = view;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCompareBinding itemCompareBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_compare, parent, false);
        return new ViewHolder(itemCompareBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.itemCompareBinding.name.setText(appliances.get(position).getAppliances().getName());
        //holder.itemCompareBinding.price.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getPrice()));
        holder.itemCompareBinding.specs.setText(appliances.get(position).getAppliances().getSpecs());

        int perc = (int)((appliances.get(position).getAppliances().getPrice()-appliances.get(position).getAppliances().getActualPrice())/appliances.get(position).getAppliances().getPrice() * 100);



        if((appliances.get(position).getAppliances().getActualPrice() <  appliances.get(position).getAppliances().getPrice())){

            holder.itemCompareBinding.price.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getPrice()));
            holder.itemCompareBinding.actualPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getActualPrice()));
            holder.itemCompareBinding.price.setVisibility(View.VISIBLE);

            holder.itemCompareBinding.percDiscount.setText(perc + "% OFF");
            holder.itemCompareBinding.percDiscount.setVisibility(View.VISIBLE);

        }else{
            holder.itemCompareBinding.actualPrice.setText("Php " + Utils.formatDecimal(appliances.get(position).getAppliances().getActualPrice()));
            holder.itemCompareBinding.price.setVisibility(View.GONE);
            holder.itemCompareBinding.percDiscount.setVisibility(View.GONE);
        }

        holder.itemCompareBinding.price.setPaintFlags(holder.itemCompareBinding.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        Glide.with(context).load(Constants.IMAGELINK + appliances.get(position).getAppliances().getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.itemCompareBinding.productImage);

        holder.itemCompareBinding.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();

                realm.beginTransaction();

                ComparedAppliances ca = realm.where(ComparedAppliances.class)
                        .equalTo("appliances.id", appliances.get(position).getAppliances().getId())
                        .findFirst();

                ca.deleteFromRealm();

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

    public void setAppliances(List<ComparedAppliances> appliances) {
        this.appliances.clear();
        this.appliances.addAll(appliances);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCompareBinding itemCompareBinding;

        public ViewHolder(ItemCompareBinding itemCompareBinding) {
            super(itemCompareBinding.getRoot());
            this.itemCompareBinding = itemCompareBinding;
        }
    }
}
