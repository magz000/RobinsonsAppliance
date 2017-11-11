package com.tip.robinsonsappliances.ui.Store;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.databinding.ItemStoresBinding;
import com.tip.robinsonsappliances.models.data.Stores;

import java.util.ArrayList;
import java.util.List;


public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private List<Stores> stores;
    private StoreView view;

    private Context context;

    public StoreAdapter(StoreView view, Context context) {
        stores = new ArrayList<>();
        this.view = view;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemStoresBinding itemStoresBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_stores, parent, false);
        return new ViewHolder(itemStoresBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemStoresBinding.name.setText(stores.get(position).getName());
        holder.itemStoresBinding.address.setText(stores.get(position).getAddress());
        holder.itemStoresBinding.contact.setText(stores.get(position).getContact());

    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public void setStores(List<Stores> appliances) {
        this.stores.clear();
        this.stores.addAll(appliances);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemStoresBinding itemStoresBinding;

        public ViewHolder(ItemStoresBinding itemStoresBinding) {
            super(itemStoresBinding.getRoot());
            this.itemStoresBinding = itemStoresBinding;
        }
    }
}
