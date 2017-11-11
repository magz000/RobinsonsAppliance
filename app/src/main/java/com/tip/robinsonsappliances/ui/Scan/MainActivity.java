package com.tip.robinsonsappliances.ui.Scan;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.zxing.integration.android.IntentIntegrator;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.AnyOrientationCaptureActivity;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.app.Utils;
import com.tip.robinsonsappliances.databinding.ActivityMainBinding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListActivity;
import com.tip.robinsonsappliances.ui.Compare.CompareActivity;
import com.tip.robinsonsappliances.ui.ContactUs.ContactUsActivity;
import com.tip.robinsonsappliances.ui.Login.LoginActivity;
import com.tip.robinsonsappliances.ui.Store.StoreActivity;
import com.tip.robinsonsappliances.ui.Tabbed.activity.TabbedActivity;
import com.tip.robinsonsappliances.ui.Wishlist.WishlistActivity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class MainActivity
        extends MvpActivity<MainView, MainPresenter>
        implements MainView ,  NavigationView.OnNavigationItemSelectedListener{

    private final int PERMISSION_CODE = 9235;
    private ActivityMainBinding binding;

    private User user;

    Appliances appliances;

    int current;

    List<Appliances> sameBrand;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.appBarMain.toolbar);



        sameBrand = new ArrayList<>();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarMain.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);
        binding.appBarMain.contentMain.layout.setOnTouchListener(new RelativeLayoutTouchListener());


        requestScan();


        presenter.start();

        user = presenter.getUser();

        ((TextView)binding.navView.getHeaderView(0).findViewById(R.id.name)).setText(user.getFirstName() + " " + user.getLastName());
        Glide.with(this).load("https://graph.facebook.com/100000404445423/picture?type=large")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .dontAnimate()
                .into((ImageView) binding.navView.getHeaderView(0).findViewById(R.id.imageView));

    }

    public void addCompare(View v){
        presenter.addToCompare(sameBrand.get(current));

        binding.appBarMain.contentMain.addCompare.setVisibility(View.GONE);
    }


    public void addWishlist(View v){
        presenter.addToWishlist(sameBrand.get(current));

        binding.appBarMain.contentMain.addWishlist.setVisibility(View.GONE);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void ScanBar (View view ) {
        requestScan();
    }

    // fucntion to scan barcode
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestScan(){
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSION_CODE);
        }else{
            startScan();
        }
    }

    public void startScan(){

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(AnyOrientationCaptureActivity.class);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(false);
        integrator.initiateScan();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);

        return true;
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent in ) {
        // TODO Auto-generated method stub

        if( requestCode == IntentIntegrator.REQUEST_CODE ){


            if( resultCode == RESULT_OK ){
                String contents = in.getStringExtra( "SCAN_RESULT" );


                appliances = presenter.getAppliance(contents);

                sameBrand = presenter.getSameBrand(appliances.getType(), appliances.getBrand());

                current = sameBrand.indexOf(appliances);

                refresh(current);

            }
        }
    }

    public void refresh(int index){
        binding.appBarMain.contentMain.name.setText(sameBrand.get(index).getName());
        binding.appBarMain.contentMain.specs.setText(sameBrand.get(index).getSpecs());
        //binding.appBarMain.contentMain.price.setText("Php " + Utils.formatDecimal(sameBrand.get(index).getPrice()));


        int perc = (int)((sameBrand.get(index).getPrice()-sameBrand.get(index).getActualPrice())/sameBrand.get(index).getPrice() * 100);

        if((sameBrand.get(index).getActualPrice() <  sameBrand.get(index).getPrice())){

            binding.appBarMain.contentMain.price.setText("Php " + Utils.formatDecimal(sameBrand.get(index).getPrice()));
            binding.appBarMain.contentMain.actualPrice.setText("Php " + Utils.formatDecimal(sameBrand.get(index).getActualPrice()));
            binding.appBarMain.contentMain.price.setVisibility(View.VISIBLE);

            binding.appBarMain.contentMain.percDiscount.setText(perc + "% OFF");
            binding.appBarMain.contentMain.percDiscount.setVisibility(View.VISIBLE);

        }else{
            binding.appBarMain.contentMain.actualPrice.setText("Php " + Utils.formatDecimal(sameBrand.get(index).getActualPrice()));
            binding.appBarMain.contentMain.price.setVisibility(View.GONE);

            binding.appBarMain.contentMain.percDiscount.setVisibility(View.GONE);
        }

        binding.appBarMain.contentMain.price.setPaintFlags(binding.appBarMain.contentMain.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(this).load(Constants.IMAGELINK + sameBrand.get(index).getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.appBarMain.contentMain.productImage);

        long contains_compared = presenter.checkIfInCompared(sameBrand.get(index));

        long contains_wishlist = presenter.checkIfInCompared(sameBrand.get(index));


        if(contains_compared > 0){
            binding.appBarMain.contentMain.addCompare.setVisibility(View.GONE);
        }else{
            binding.appBarMain.contentMain.addCompare.setVisibility(View.VISIBLE
            );
        }

        if(contains_wishlist > 0){
            binding.appBarMain.contentMain.addWishlist.setVisibility(View.GONE);
        }else{
            binding.appBarMain.contentMain.addWishlist.setVisibility(View.VISIBLE
            );
        }

        if (index > 0) {
            binding.appBarMain.contentMain.up.setVisibility(View.VISIBLE);
            binding.appBarMain.contentMain.up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    current--;
                    refresh(current);
                }
            });
        } else {
            binding.appBarMain.contentMain.up.setVisibility(View.GONE);
        }

        if (index < sameBrand.size() - 1) {
            binding.appBarMain.contentMain.down.setVisibility(View.VISIBLE);
            binding.appBarMain.contentMain.down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    current++;
                    refresh(current);
                }
            });
        } else {
            binding.appBarMain.contentMain.down.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startScan();
            }
            else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_product:
                startScan();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        else if(id == R.id.compare){
            startActivity(new Intent(this, CompareActivity.class));
            finish();
        }else if(id == R.id.wishlist){
            startActivity(new Intent(this, WishlistActivity.class));
            finish();
        }else if(id == R.id.contact_us){
            startActivity(new Intent(this, ContactUsActivity.class));
        }else if(id == R.id.store){
            startActivity(new Intent(this, StoreActivity.class));
            finish();
        }else if(id == R.id.scan){
            //startActivity(new Intent(this, MainActivity.class));

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
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
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


    public class RelativeLayoutTouchListener implements View.OnTouchListener {

        static final String logTag = "ActivitySwipeDetector";
        static final int MIN_DISTANCE = 100;// TODO change this runtime based on screen resolution. for 1920x1080 is to small the 100 distance
        private float downX, downY, upX, upY;

        // private MainActivity mMainActivity;

        public RelativeLayoutTouchListener() {

        }



        public void onTopToBottomSwipe() {
            Log.i(logTag, "onTopToBottomSwipe!");

            if(current > 0){
                current--;
                refresh(current);
            }
        }

        public void onBottomToTopSwipe() {
            Log.i(logTag, "onBottomToTopSwipe!");
            if(current < sameBrand.size()-1){
                current++;
                refresh(current);
            }

        }

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    downY = event.getY();
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    upX = event.getX();
                    upY = event.getY();

                    float deltaX = downX - upX;
                    float deltaY = downY - upY;


                    if (Math.abs(deltaY) > MIN_DISTANCE) {
                        // top or down
                        if (deltaY < 0) {
                            this.onTopToBottomSwipe();
                            return true;
                        }
                        if (deltaY > 0) {
                            this.onBottomToTopSwipe();
                            return true;
                        }
                    }

                    return false; // no swipe horizontally and no swipe vertically
                }// case MotionEvent.ACTION_UP:
            }
            return false;
        }

    }

}
