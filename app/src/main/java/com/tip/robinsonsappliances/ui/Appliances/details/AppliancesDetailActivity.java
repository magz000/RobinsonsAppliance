package com.tip.robinsonsappliances.ui.Appliances.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.databinding.ActivityAppliancesDetail2Binding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.ui.Appliances.details.fragment.FragmentAppliancesDetails;
import com.tip.robinsonsappliances.ui.Appliances.details.fragment.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AppliancesDetailActivity
        extends MvpActivity<AppliancesDetailView, AppliancesDetailPresenter>
        implements AppliancesDetailView {

    private ActivityAppliancesDetail2Binding binding;

   private ViewPagerAdapter viewPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    int id;

    String type;

    boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_appliances_detail2);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id = getIntent().getIntExtra(Constants.ID, -1);
        type = getIntent().getStringExtra(Constants.TYPE);

        switch(type){
            case "television":
                setTitle("Televisions");
                break;
            case "audio":
                setTitle("Audio-Video Player");
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

        if (id == -1) {
            Toast.makeText(getApplicationContext(), "No Intent Extra Found", Toast.LENGTH_SHORT).show();
            finish();
        }
        presenter.start(type);
    }

    @Override
    protected void onDestroy() {
        presenter.stop();
        super.onDestroy();
    }

    @NonNull
    @Override
    public AppliancesDetailPresenter createPresenter() {
        return new AppliancesDetailPresenter();
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
    public void setAppliances(List<Appliances> appliances) {

        if(!check) {

            ArrayList<String> brands = new ArrayList<>();

            Appliances app = new Appliances();
            app.setId(id);

            viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

            int curr = appliances.indexOf(app);

            for (int x = 0; x < appliances.size(); x++) {
                if (!brands.contains(appliances.get(x).getBrand())) {

                    if (appliances.get(appliances.indexOf(app)).getBrand().equals(appliances.get(x).getBrand())) {
                        curr = x;
                        viewPagerAdapter.addFrag(new FragmentAppliancesDetails().newInstance(x, id, type), appliances.get(x).getName());
                    } else {
                        viewPagerAdapter.addFrag(new FragmentAppliancesDetails().newInstance(x, appliances.get(x).getId(), type), appliances.get(x).getName());
                    }
                    brands.add(appliances.get(x).getBrand());
                }
            }

            binding.container.setAdapter(viewPagerAdapter);

            binding.container.setOffscreenPageLimit(appliances.size());

            binding.container.setCurrentItem(curr);

            check = true;
        }


    }


}
