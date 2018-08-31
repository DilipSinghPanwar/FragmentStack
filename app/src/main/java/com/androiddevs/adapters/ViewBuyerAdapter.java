package com.androiddevs.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androiddevs.R;
import com.androiddevs.fragment.PostSellerFragment;
import com.androiddevs.models.ViewBuyerModel;

import java.util.List;


public class ViewBuyerAdapter extends RecyclerView.Adapter<ViewBuyerAdapter.RecyclerViewViewHolder> {

    private final FragmentManager fragmentManager;
    private RecyclerViewViewHolder viewHolder;
    private View view;
    public static Context ctx;
    List<ViewBuyerModel> mSellPropertyModelList;

    public ViewBuyerAdapter(Context ctx,FragmentManager fragmentManager, List<ViewBuyerModel> mSellPropertyModelList) {
        this.ctx = ctx;
        this.fragmentManager = fragmentManager;
        this.mSellPropertyModelList = mSellPropertyModelList;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_itemlist, parent, false);
        viewHolder = new RecyclerViewViewHolder(view,fragmentManager);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {

        viewHolder._name.setText(mSellPropertyModelList.get(position).getPropertyName());
        viewHolder._description.setText(mSellPropertyModelList.get(position).getPropertyDetails());
    }

    @Override
    public int getItemCount() {
        return mSellPropertyModelList.size();
    }

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView _name;
        TextView _description;
        ImageView _icon;
        FragmentManager fragmentManager;

        public RecyclerViewViewHolder(View itemView,FragmentManager fragmentManager) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.fragmentManager = fragmentManager;
            cv = (CardView) itemView.findViewById(R.id.cv);
            _name = (TextView) itemView.findViewById(R.id.tvName);
            _description = (TextView) itemView.findViewById(R.id.tvDescription);
            _icon = (ImageView) itemView.findViewById(R.id.ivIcon);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();

            //            Intent _intent = new Intent(v.getContext(), IDA.class);
//            _intent.putExtra("position", position);
//            v.getContext().startActivity(_intent);

           /* switch (pos){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
            }*/

            Fragment fragment = new PostSellerFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, fragment);
            fragmentTransaction.addToBackStack("PostSellerFragment");
            fragmentTransaction.commit();


        }
    }
}