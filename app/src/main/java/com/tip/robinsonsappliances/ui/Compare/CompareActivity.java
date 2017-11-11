package com.tip.robinsonsappliances.ui.Compare;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.databinding.ActivityCompareBinding;
import com.tip.robinsonsappliances.models.data.ComparedAppliances;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListActivity;
import com.tip.robinsonsappliances.ui.ContactUs.ContactUsActivity;
import com.tip.robinsonsappliances.ui.Login.LoginActivity;
import com.tip.robinsonsappliances.ui.Scan.MainActivity;
import com.tip.robinsonsappliances.ui.Store.StoreActivity;
import com.tip.robinsonsappliances.ui.Tabbed.activity.TabbedActivity;
import com.tip.robinsonsappliances.ui.Wishlist.WishlistActivity;

import java.util.List;

import io.realm.Realm;


public class CompareActivity
        extends MvpViewStateActivity<CompareView, ComparePresenter>
        implements CompareView,  NavigationView.OnNavigationItemSelectedListener{

    private ActivityCompareBinding binding;

    private CompareAdapter adapter;

    private User user;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView(this, R.layout.activity_compare);

        setSupportActionBar(binding.appBarCompare.toolbar);



        adapter = new CompareAdapter(getMvpView(), this);
        binding.appBarCompare.contentCompare.recyclerView.setAdapter(adapter);
        binding.appBarCompare.contentCompare.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarCompare.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);

        presenter.start();

        user = presenter.getUser();

        ((TextView)binding.navView.getHeaderView(0).findViewById(R.id.name)).setText(user.getFirstName() + " " + user.getLastName());

        Glide.with(this).load("https://graph.facebook.com/100000404445423/picture?type=large")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .dontAnimate()
                .into((ImageView) binding.navView.getHeaderView(0).findViewById(R.id.imageView));
    }

    @NonNull
    @Override
    public ComparePresenter createPresenter() {
        return new ComparePresenter();
    }

    @Override
    public ViewState<CompareView> createViewState() {
        setRetainInstance(true);
        return new CompareViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        //presenter.refresh();
    }

    @Override
    public void setAppliance(List<ComparedAppliances> appliances) {
        adapter.setAppliances(appliances);

        if(adapter.getItemCount() > 0) {
            binding.appBarCompare.contentCompare.noContent.emptyLayout.setVisibility(View.INVISIBLE);
            binding.appBarCompare.contentCompare.recyclerView.setVisibility(View.VISIBLE);

        }else{
            binding.appBarCompare.contentCompare.noContent.emptyLayout.setVisibility(View.VISIBLE);
            binding.appBarCompare.contentCompare.recyclerView.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this, TabbedActivity.class);
            intent.putExtra(Constants.TYPE, "television");
            startActivity(intent);
            finish();
        }
//        else if(id == R.id.audio_players) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "audio");
//            startActivity(intent);
//            finish();
//
//        }else if(id == R.id.home_appliances) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "home");
//            startActivity(intent);
//            finish();
//
//        }else if(id == R.id.kitchen_appliances) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "kitchen");
//            startActivity(intent);
//            finish();
//
//        }else if(id == R.id.gadgets) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "gadgets");
//            startActivity(intent);
//            finish();
//
//        }
        else if(id == R.id.wishlist){
            startActivity(new Intent(this, WishlistActivity.class));
            finish();
        }
        else if(id == R.id.scan){
            startActivity(new Intent(this, MainActivity.class));
            finish();

        }else if(id == R.id.contact_us){
            startActivity(new Intent(this, ContactUsActivity.class));
        }else if(id == R.id.store){
            startActivity(new Intent(this, StoreActivity.class));
            finish();
        }else if (id == R.id.logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Log Out");
            builder.setMessage("Are you sure?");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Do nothing but close the dialog
                    final Realm realm = Realm.getDefaultInstance();
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.deleteAll();
                        }
                    }, new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            realm.close();
                            // TODO: 12/4/2016 add flag to clear all task
                            startActivity(new Intent(CompareActivity.this, LoginActivity.class));
                            finish();
                        }
                    }, new Realm.Transaction.OnError() {
                        @Override
                        public void onError(Throwable error) {
                            realm.close();
                        }
                    });
                    finish();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // Do nothing
                    dialog.dismiss();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
