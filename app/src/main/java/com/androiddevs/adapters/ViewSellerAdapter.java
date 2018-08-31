package com.androiddevs.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.androiddevs.R;
import com.androiddevs.models.ViewSellerModel;
import java.util.List;


public class ViewSellerAdapter extends RecyclerView.Adapter<ViewSellerAdapter.RecyclerViewViewHolder> {

    private RecyclerViewViewHolder viewHolder;
    private View view;
    Context ctx;
    List<ViewSellerModel> mSellPropertyModelList;

    public ViewSellerAdapter(Context ctx, List<ViewSellerModel> mSellPropertyModelList) {
        this.ctx = ctx;
        this.mSellPropertyModelList = mSellPropertyModelList;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_itemlist, parent, false);
        viewHolder = new RecyclerViewViewHolder(view);
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

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
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

        }
    }

}