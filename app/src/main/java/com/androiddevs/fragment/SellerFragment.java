package com.androiddevs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androiddevs.R;
import com.androiddevs.adapters.SellerAdapter;
import com.androiddevs.models.ViewSellerModel;

import java.util.ArrayList;

public class SellerFragment extends Fragment {

    private ArrayList<ViewSellerModel> mSellPropertyModelDTOList;
    private RecyclerView mRecyclerView;
    private SellerAdapter mRCAdapter;

    public SellerFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_seller, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSellPropertyModelDTOList = new ArrayList<ViewSellerModel>();
        mSellPropertyModelDTOList.add(new ViewSellerModel("Seller Name1","Seller Details1","",""));
        mSellPropertyModelDTOList.add(new ViewSellerModel("Seller Name1","Seller Details1","",""));
        mSellPropertyModelDTOList.add(new ViewSellerModel("Seller Name1","Seller Details1","",""));
        mSellPropertyModelDTOList.add(new ViewSellerModel("Seller Name1","Seller Details1","",""));

        mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.rvItem);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

//        mItem = getResources().getStringArray(R.array.mp_english_item);
//        mItemDescription = getResources().getStringArray(R.array.mp_english_item_description);

//        for (int i = 0; i < mItem.length; i++) {
//            mItemDTO = new SellPropertyModel();
//            mItemDTO.setPropertyName(mItem[i]);
//            mItemDTO.setPropertyDetails(mItemDescription[i]);
//            mSellPropertyModelDTOList.add(mItemDTO);
//        }

            mRCAdapter = new SellerAdapter(getActivity(), mSellPropertyModelDTOList);
            mRecyclerView.setAdapter(mRCAdapter);

    }
}
