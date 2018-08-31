package com.androiddevs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androiddevs.R;
import com.androiddevs.adapters.ViewBuyerAdapter;
import com.androiddevs.models.ViewBuyerModel;

import java.util.ArrayList;

public class ViewBuyerFragment extends Fragment {

    private ArrayList<ViewBuyerModel> mSellPropertyModelDTOList;
    private RecyclerView mRecyclerView;
    private ViewBuyerAdapter mRCAdapter;

    public ViewBuyerFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_viewbuyer, container, false);
         
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSellPropertyModelDTOList = new ArrayList<ViewBuyerModel>();
        mSellPropertyModelDTOList.add(new ViewBuyerModel("Buyer Name1","Buyer Details1","",""));
        mSellPropertyModelDTOList.add(new ViewBuyerModel("Buyer Name1","Buyer Details1","",""));
        mSellPropertyModelDTOList.add(new ViewBuyerModel("Buyer Name1","Buyer Details1","",""));
        mSellPropertyModelDTOList.add(new ViewBuyerModel("Buyer Name1","Buyer Details1","",""));


        mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.rvItem);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        mRCAdapter = new ViewBuyerAdapter(getActivity(),fragmentManager, mSellPropertyModelDTOList);
        mRecyclerView.setAdapter(mRCAdapter);

    }
}
