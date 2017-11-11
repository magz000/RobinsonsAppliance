package com.tip.robinsonsappliances.ui.Appliances.list;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.tip.robinsonsappliances.R;

import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.databinding.ActivityAppliancesListBinding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.ui.Appliances.details.AppliancesDetailActivity;
import com.tip.robinsonsappliances.ui.Compare.CompareActivity;
import com.tip.robinsonsappliances.ui.ContactUs.ContactUsActivity;
import com.tip.robinsonsappliances.ui.Login.LoginActivity;
import com.tip.robinsonsappliances.ui.Scan.MainActivity;
import com.tip.robinsonsappliances.ui.Store.StoreActivity;
import com.tip.robinsonsappliances.ui.Wishlist.WishlistActivity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;

//import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class AppliancesListActivity
        extends MvpViewStateActivity<AppliancesListView, AppliancesListPresenter>
        implements AppliancesListView, SwipeRefreshLayout.OnRefreshListener, NavigationView.OnNavigationItemSelectedListener
        , GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private ActivityAppliancesListBinding binding;
    private AppliancesListAdapter adapter;

    boolean backpressed = false;
    Toast t;

    ArrayList<String> promos = new ArrayList<>();

    private final int PERMISSION_CODE = 9235;

    String type;

    private User user;

    GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_appliances_list);

        setSupportActionBar(binding.appBarAppliancesList.toolbar);


        buildGoogleApiClient();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        } else {
            Toast.makeText(this, "Not connected...", Toast.LENGTH_SHORT).show();
        }



        //recycler view
        binding.appBarAppliancesList.contentAppliancesList.swipeRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.swipe_refresh_layout_color_scheme));
        binding.appBarAppliancesList.contentAppliancesList.swipeRefreshLayout.setOnRefreshListener(this);
        adapter = new AppliancesListAdapter(getMvpView(), this);

        AlphaInAnimationAdapter alpha = new AlphaInAnimationAdapter(adapter);
        alpha.setFirstOnly(false);


        ScaleInAnimationAdapter animatorAdapter = new ScaleInAnimationAdapter(alpha);
        animatorAdapter.setDuration(300);
        animatorAdapter.setFirstOnly(false);

        binding.appBarAppliancesList.contentAppliancesList.recyclerView.setAdapter(animatorAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        binding.appBarAppliancesList.contentAppliancesList.recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //binding.appBarAppliancesList.contentAppliancesList.recyclerView.setItemAnimator(new SlideInDownAnimator(new OvershootInterpolator(1f)));

        //navigation drawer setup
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarAppliancesList.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);

        //Set title
        type = getIntent().getStringExtra(Constants.TYPE);

        if (type == null || type.equals("")) {
            type = "television";
        }

        switch (type) {
            case "television":
                setTitle("Televisions");
                break;
            case "audio":
                setTitle("Audio-Video Players");
                break;
            case "home":
                setTitle("Home Appliances");
                break;
            case "kitchen":
                setTitle("Kitchen Appliances");
                break;
            case "gadgets":
                setTitle("Gadgets");
                break;
            default:
                break;
        }

        Log.e("Type", type);

        promos.add("assets/img/robinsonsappliances/slide/ra-mdg.jpg");
        promos.add("assets/img/robinsonsappliances/slide/ra-grab-promo.jpg");
        promos.add("assets/img/robinsonsappliances/slide/ra-hongkong-escapade.jpg");
        promos.add("assets/img/robinsonsappliances/slide/ra-bpi-promo-free-health-grill.jpg");
        promos.add("assets/img/robinsonsappliances/slide/Zero_Cash_Out.JPG");
        promos.add("assets/img/robinsonsappliances/slide/aeon-credit-web-banner.png");
        promos.add("assets/img/robinsonsappliances/slide/ra-cool-deals-april12.JPG");

        //SearchView
        binding.appBarAppliancesList.searchView.setVoiceSearch(false);
        binding.appBarAppliancesList.searchView.setCursorDrawable(R.drawable.custom_cursor);
        binding.appBarAppliancesList.searchView.setEllipsize(true);
        binding.appBarAppliancesList.searchView.setHint("Search");
        binding.appBarAppliancesList.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                doSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                doSearch(newText);
                return true;
            }
        });

        //displayPromo();

        presenter.onStart(type);

        user = presenter.getUser();

        ((TextView) binding.navView.getHeaderView(0).findViewById(R.id.name)).setText(user.getFirstName() + " " + user.getLastName());

        Glide.with(AppliancesListActivity.this).load("https://graph.facebook.com/100000404445423/picture?type=large")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .dontAnimate()
                .into((ImageView) binding.navView.getHeaderView(0).findViewById(R.id.imageView));

    }


    @Override
    protected void onDestroy() {
        presenter.onStop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        t = Toast.makeText(this, "Press again to exit.", Toast.LENGTH_SHORT);

        if (backpressed) {
            super.onBackPressed();
            t.cancel();
        } else {
            this.backpressed = true;
            t.show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    backpressed = false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this, AppliancesListActivity.class);
            intent.putExtra(Constants.TYPE, "television");
            startActivity(intent);
            finish();
        }
//        else if (id == R.id.audio_players) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "audio");
//            startActivity(intent);
//            finish();
//
//        } else if (id == R.id.home_appliances) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "home");
//            startActivity(intent);
//            finish();
//
//        } else if (id == R.id.kitchen_appliances) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "kitchen");
//            startActivity(intent);
//            finish();
//
//        } else if (id == R.id.gadgets) {
//            Intent intent = new Intent(this, AppliancesListActivity.class);
//            intent.putExtra(Constants.TYPE, "gadgets");
//            startActivity(intent);
//            finish();
//
//        }
        else if (id == R.id.compare) {
            startActivity(new Intent(this, CompareActivity.class));
        } else if (id == R.id.scan) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.wishlist) {
            startActivity(new Intent(this, WishlistActivity.class));
        } else if (id == R.id.contact_us) {
            startActivity(new Intent(this, ContactUsActivity.class));
        } else if (id == R.id.store) {
            startActivity(new Intent(this, StoreActivity.class));
        } else if (id == R.id.logout) {
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
                            startActivity(new Intent(AppliancesListActivity.this, LoginActivity.class));
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        binding.appBarAppliancesList.searchView.setMenuItem(item);

        return true;
    }


    public void doSearch(String text) {
        presenter.search(text, type);
    }


    @NonNull
    @Override
    public AppliancesListPresenter createPresenter() {
        return new AppliancesListPresenter();
    }

    @Override
    public void onRefresh() {
        presenter.refresh();
    }

    @Override
    public void setAppliances(List<Appliances> appliances) {
        adapter.setAppliances(appliances);
        if (adapter.getItemCount() > 0) {
            binding.appBarAppliancesList.contentAppliancesList.noContent.emptyLayout.setVisibility(View.INVISIBLE);
            binding.appBarAppliancesList.contentAppliancesList.recyclerView.setVisibility(View.VISIBLE);

        } else {
            binding.appBarAppliancesList.contentAppliancesList.noContent.emptyLayout.setVisibility(View.VISIBLE);
            binding.appBarAppliancesList.contentAppliancesList.recyclerView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void stopLoading() {
        binding.appBarAppliancesList.contentAppliancesList.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onApplianceClicked(Appliances appliances) {
        Intent intent = new Intent(this, AppliancesDetailActivity.class);
        intent.putExtra(Constants.ID, appliances.getId());
        intent.putExtra(Constants.TYPE, appliances.getType());
        startActivity(intent);
    }

    @NonNull
    @Override
    public ViewState<AppliancesListView> createViewState() {
        setRetainInstance(true);
        return new AppliancesListViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        binding.appBarAppliancesList.contentAppliancesList.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                binding.appBarAppliancesList.contentAppliancesList.swipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_CODE);
        } else {

            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);

            if (mLastLocation != null) {
//                Toast.makeText(this, "Latitude: " + String.valueOf(mLastLocation.getLatitude()) + "Longitude: " +
//                        String.valueOf(mLastLocation.getLongitude()), Toast.LENGTH_SHORT).show();
                presenter.updateLocation(mLastLocation);
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "Connection suspended...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Failed to connect...", Toast.LENGTH_SHORT).show();

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //mGoogleApiClient.connect();
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);

                if (mLastLocation != null) {
                    presenter.updateLocation(mLastLocation);
                }
            }else{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
