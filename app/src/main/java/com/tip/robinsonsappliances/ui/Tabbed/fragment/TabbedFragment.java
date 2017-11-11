package com.tip.robinsonsappliances.ui.Tabbed.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.app.Constants;
import com.tip.robinsonsappliances.databinding.FragmentTabbedBinding;
import com.tip.robinsonsappliances.models.data.Appliances;
import com.tip.robinsonsappliances.ui.Appliances.details.AppliancesDetailActivity;
import com.tip.robinsonsappliances.ui.Appliances.list.AppliancesListAdapter;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;



public class TabbedFragment extends MvpFragment<TabbedFragmentView, TabbedFragmentPresenter> implements TabbedFragmentView {

    FragmentTabbedBinding binding;

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_TYPE = "type";

    TabbedFragmentAdapter adapter;

    public TabbedFragment() {
    }




    public static TabbedFragment newInstance(int sectionNumber, String type) {
        TabbedFragment fragment = new TabbedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tabbed, container, false);
        View rootView = binding.getRoot();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String type = getArguments().getString(ARG_TYPE);

        adapter = new TabbedFragmentAdapter(getMvpView(), getActivity());

        //binding.sectionLabel.setText(getArguments().getString(ARG_TYPE));
//        AlphaInAnimationAdapter alpha = new AlphaInAnimationAdapter(adapter);
//        alpha.setFirstOnly(false);
//
//
//        ScaleInAnimationAdapter animatorAdapter = new ScaleInAnimationAdapter(alpha);
//        animatorAdapter.setDuration(300);
//        animatorAdapter.setFirstOnly(false);

        binding.recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);

        presenter.onStart(type);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.onStop();
    }

    @Override
    public TabbedFragmentPresenter createPresenter() {
        return new TabbedFragmentPresenter();
    }


    @Override
    public void setAppliances(List<Appliances> appliances) {
        adapter.setAppliances(appliances);
    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onApplianceClicked(Appliances appliances) {
        Intent intent = new Intent(getActivity(), AppliancesDetailActivity.class);
        intent.putExtra(Constants.ID, appliances.getId());
        intent.putExtra(Constants.TYPE, appliances.getType());
        startActivity(intent);
    }
}
