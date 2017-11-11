package com.tip.robinsonsappliances.ui.Appliances.details.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.CalculateDistanceTime;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.app.Utils;
import com.tip.robinsonsappliances.databinding.FragmentApplicationDetailsBinding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.models.data.CurrentLocation;

import java.util.ArrayList;
import java.util.List;




public class FragmentAppliancesDetails
        extends MvpFragment<FragmentAppliancesDetailView, FragmentAppliancesDetailPresenter>
        implements FragmentAppliancesDetailView{

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    FragmentApplicationDetailsBinding binding;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<Appliances> sameBrand;

    int current;

    int id;
    int sectionNumber;
    String type;

    public FragmentAppliancesDetails() {
    }

    @Override
    public FragmentAppliancesDetailPresenter createPresenter() {
        return new FragmentAppliancesDetailPresenter();
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentAppliancesDetails newInstance(int sectionNumber, int id, String type) {
        FragmentAppliancesDetails fragment = new FragmentAppliancesDetails();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt(Constants.ID, id);
        args.putString(Constants.TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_application_details, container, false);
        View rootView = binding.getRoot();

        id = getArguments().getInt(Constants.ID);
        sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        type = getArguments().getString(Constants.TYPE);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.start(id);
    }

    @Override
    public void setAppliances(final Appliances appliances) {
        final Appliances app = new Appliances();
        app.setId(id);

        sameBrand = presenter.getSameBrand(appliances.getType(), appliances.getBrand());

        current = sameBrand.indexOf(appliances);

        refresh(current);

        binding.relativeLayout.setOnTouchListener(new RelativeLayoutTouchListener());

        binding.addCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addToCompare(sameBrand.get(current));
                binding.addCompare.setVisibility(View.GONE);
                refresh(current);
            }
        });

        binding.addWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addToWishlist(sameBrand.get(current));
                binding.addWishlist.setVisibility(View.GONE);
                refresh(current);
            }
        });
    }


    public void refresh(int index){
        try {
            binding.name.setText(sameBrand.get(index).getName());
            binding.price.setText("Php " + Utils.formatDecimal(sameBrand.get(index).getPrice()));
            binding.specs.setText(sameBrand.get(index).getSpecs());
            binding.nearest.setText("Nearest Store: Robinsons Galleria");

            CurrentLocation curr = presenter.getCurrentLocation();

            calculateTimeDistance(curr.getLatitude(), 14.6038967, curr.getLongitude(), 121.0635192);

            Glide.with(this).load(Constants.IMAGELINK + sameBrand.get(index).getImage())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(binding.productImage);

            long contains_compared = presenter.checkIfInCompared(sameBrand.get(index));

            long contains_wishlist = presenter.checkIfInWishlist(sameBrand.get(index));

            if(contains_compared > 0){
                binding.addCompare.setVisibility(View.GONE);
            }else{
                binding.addCompare.setVisibility(View.VISIBLE
                );
            }

            if(contains_wishlist > 0){
                binding.addWishlist.setVisibility(View.GONE);
            }else{
                binding.addWishlist.setVisibility(View.VISIBLE);
            }

            if (index > 0) {
                binding.up.setVisibility(View.VISIBLE);
                binding.up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        current--;
                        refresh(current);
                    }
                });
            } else {
                binding.up.setVisibility(View.GONE);
            }

            if (index < sameBrand.size() - 1) {
                binding.down.setVisibility(View.VISIBLE);
                binding.down.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        current++;
                        refresh(current);
                    }
                });
            } else {
                binding.down.setVisibility(View.GONE);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


    }

    public class RelativeLayoutTouchListener implements View.OnTouchListener {

        static final String logTag = "ActivitySwipeDetector";
        static final int MIN_DISTANCE = 100;// TODO change this runtime based on screen resolution. for 1920x1080 is to small the 100 distance
        private float downY, upY;


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
                    downY = event.getY();
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    upY = event.getY();

                    float deltaY = downY - upY;

                    if (Math.abs(deltaY) > MIN_DISTANCE) {
                        if (deltaY < 0) {
                            this.onTopToBottomSwipe();
                            return true;
                        }
                        if (deltaY > 0) {
                            this.onBottomToTopSwipe();
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }

    }

    public void calculateTimeDistance(double oLat, double dLat, double oLong, double dLong){
        CalculateDistanceTime distance_task = new CalculateDistanceTime(getActivity());

        LatLng startLatLng, endLatLng;

        endLatLng = new LatLng(dLat, dLong);

        try {

            startLatLng = new LatLng(oLat, oLong);


            distance_task.getDirectionsUrl(startLatLng, endLatLng);

            distance_task.setLoadListener(new CalculateDistanceTime.taskCompleteListener() {
                @Override
                public void taskCompleted(String[] time_distance, ArrayList<String> points) {

                    //textView.setText("Distance: " + time_distance[1] + "  Time: " +time_distance[0]);
                    binding.distance.setText("Distance: " + time_distance[1] + "  Time: " +time_distance[0]);
                }

            });

        } catch (SecurityException e) {
            Log.e("Location:", e.getMessage());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }
}
