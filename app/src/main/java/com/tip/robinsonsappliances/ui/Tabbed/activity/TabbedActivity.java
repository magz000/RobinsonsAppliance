package com.tip.robinsonsappliances.ui.Tabbed.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Build;
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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.databinding.ActivityTabbedBinding;
import com.tip.robinsonsappliances.databinding.SpinnerItemBinding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.ui.Appliances.details.AppliancesDetailActivity;
import com.tip.robinsonsappliances.ui.Compare.CompareActivity;
import com.tip.robinsonsappliances.ui.ContactUs.ContactUsActivity;
import com.tip.robinsonsappliances.ui.Login.LoginActivity;
import com.tip.robinsonsappliances.ui.Scan.MainActivity;
import com.tip.robinsonsappliances.ui.Store.StoreActivity;
import com.tip.robinsonsappliances.ui.Tabbed.fragment.TabbedFragment;
import com.tip.robinsonsappliances.ui.Wishlist.WishlistActivity;

import java.util.List;

import io.realm.Realm;

import static android.view.View.GONE;

public class TabbedActivity extends MvpViewStateActivity<TabbedView, TabbedPresenter> implements TabbedView,
        NavigationView.OnNavigationItemSelectedListener, SwipeRefreshLayout.OnRefreshListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{


    private SectionsPagerAdapter mSectionsPagerAdapter;

    ActivityTabbedBinding binding;

    User user;

    private final int PERMISSION_CODE = 9235;

    GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;

    TabbedAdapter adapter;

    boolean backpressed = false;
    Toast t;


    String textSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tabbed);

        setSupportActionBar(binding.appBarTabbed.toolbar);

        buildGoogleApiClient();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        } else {
            Toast.makeText(this, "Not connected...", Toast.LENGTH_SHORT).show();
        }


        //navigation drawer setup
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarTabbed.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        adapter = new TabbedAdapter(getMvpView(), this);
        binding.appBarTabbed.contentTabbed.recyclerView.setAdapter(adapter);


        binding.appBarTabbed.contentTabbed.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        binding.navView.setNavigationItemSelectedListener(this);

        binding.appBarTabbed.contentTabbed.swipeRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.swipe_refresh_layout_color_scheme));
        binding.appBarTabbed.contentTabbed.swipeRefreshLayout.setOnRefreshListener(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        binding.appBarTabbed.contentTabbed.viewPager.setAdapter(mSectionsPagerAdapter);
        binding.appBarTabbed.contentTabbed.viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());

        binding.appBarTabbed.tabs.setupWithViewPager(binding.appBarTabbed.contentTabbed.viewPager);

        presenter.onStart();

        user = presenter.getUser();

        ((TextView) binding.navView.getHeaderView(0).findViewById(R.id.name)).setText(user.getFirstName() + " " + user.getLastName());

        Glide.with(TabbedActivity.this).load("https://graph.facebook.com/100000404445423/picture?type=large")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .dontAnimate()
                .into((ImageView) binding.navView.getHeaderView(0).findViewById(R.id.imageView));


        binding.appBarTabbed.searchView.setVoiceSearch(false);
        binding.appBarTabbed.searchView.setCursorDrawable(R.drawable.custom_cursor);
        binding.appBarTabbed.searchView.setEllipsize(true);
        binding.appBarTabbed.searchView.setHint("Search");
        binding.appBarTabbed.searchView.setHintTextColor(R.color.black);
        binding.appBarTabbed.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                doSearch(query);
                textSearch = query;

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                doSearch(newText);
                textSearch = newText;

                return true;
            }
        });

        binding.appBarTabbed.searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
                binding.appBarTabbed.tabs.setVisibility(GONE);
                binding.appBarTabbed.contentTabbed.swipeRefreshLayout.setVisibility(GONE);
                binding.appBarTabbed.contentTabbed.viewPager.setVisibility(GONE);
                binding.appBarTabbed.contentTabbed.searchLayout.setVisibility(View.VISIBLE);
                binding.appBarTabbed.contentTabbed.noQuery.noQuery.setVisibility(View.VISIBLE);
                binding.appBarTabbed.contentTabbed.recyclerView.setVisibility(GONE);
                //binding.appBarTabbed.contentTabbed.noContent.emptyLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
                binding.appBarTabbed.tabs.setVisibility(View.VISIBLE);
                binding.appBarTabbed.contentTabbed.swipeRefreshLayout.setVisibility(View.VISIBLE);
                binding.appBarTabbed.contentTabbed.viewPager.setVisibility(View.VISIBLE);
                binding.appBarTabbed.contentTabbed.searchLayout.setVisibility(View.GONE);
                binding.appBarTabbed.contentTabbed.noQuery.noQuery.setVisibility(View.GONE);
            }
        });


        //spinner

        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item , R.id.text);

        binding.appBarTabbed.contentTabbed.spinner.setAdapter(spinnerAdapter);

        spinnerAdapter.add("Price");
        spinnerAdapter.add("Name");
        spinnerAdapter.notifyDataSetChanged();

        binding.appBarTabbed.contentTabbed.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.changeType(binding.appBarTabbed.contentTabbed.spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void doSearch(String text) {
        if(text.trim().equals("")) {
            binding.appBarTabbed.contentTabbed.noQuery.noQuery.setVisibility(View.VISIBLE);
            binding.appBarTabbed.contentTabbed.noResult.noResult.setVisibility(View.GONE);
            binding.appBarTabbed.contentTabbed.recyclerView.setVisibility(View.GONE);

            presenter.search(text);
        }else {
            binding.appBarTabbed.contentTabbed.noQuery.noQuery.setVisibility(View.GONE);
            binding.appBarTabbed.contentTabbed.recyclerView.setVisibility(View.VISIBLE);
            presenter.search(text);
        }
    }

    @NonNull
    @Override
    public TabbedPresenter createPresenter() {
        return new TabbedPresenter();
    }


    @Override
    public ViewState<TabbedView> createViewState() {
        return new TabbedViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        binding.appBarTabbed.contentTabbed.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                binding.appBarTabbed.contentTabbed.swipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        binding.appBarTabbed.searchView.setMenuItem(item);

        return true;
    }

    @Override
    public void onBackPressed() {

        if (binding.appBarTabbed.searchView.isSearchOpen()) {
            binding.appBarTabbed.searchView.closeSearch();
        } else {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            } else {
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
        }
    }

    @Override
    public void onRefresh() {
        presenter.refresh();
    }

    @Override
    protected void onDestroy() {
        presenter.onStop();
        super.onDestroy();
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

    }

    @Override
    public void setAppliances(List<Appliances> appliances) {
        adapter.setAppliances(appliances);

        if (adapter.getItemCount() > 0) {
            binding.appBarTabbed.contentTabbed.noResult.noResult.setVisibility(View.INVISIBLE);
            binding.appBarTabbed.contentTabbed.recyclerView.setVisibility(View.VISIBLE);

        } else {
            binding.appBarTabbed.contentTabbed.noResult.noResult.setVisibility(View.VISIBLE);
            binding.appBarTabbed.contentTabbed.recyclerView.setVisibility(View.INVISIBLE);

            binding.appBarTabbed.contentTabbed.noResult.keyword.setText(textSearch);
        }
    }

    @Override
    public void stopLoading() {
        binding.appBarTabbed.contentTabbed.swipeRefreshLayout.setRefreshing(false);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this, TabbedActivity.class);
            intent.putExtra(Constants.TYPE, "television");
            startActivity(intent);
            finish();
        }
//      else if (id == R.id.audio_players) {
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
                            startActivity(new Intent(TabbedActivity.this, LoginActivity.class));
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
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        String title[] = {"television", "audio", "home", "kitchen", "gadgets"};

        @Override
        public Fragment getItem(int position) {

            return TabbedFragment.newInstance(position + 1, title[position]);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Televisions";
                case 1:
                    return "Audio-Video Players";
                case 2:
                    return "Home Appliances";
                case 3:
                    return "Kitchen Appliances";
                case 4:
                    return "Gadgets";
            }
            return null;
        }
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
