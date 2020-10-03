package com.example.themintempire.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themintempire.Models.PlateModel;
import com.example.themintempire.R;

import java.util.List;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.PlateViewHolder> {
    private List<PlateModel> plateModelList;
    private Context context;

    //This is like the empty constructor in the PlateModel class
    public PlateAdapter(List<PlateModel> plateModelList, Context context) {
        this.plateModelList = plateModelList;
        this.context = context;
    }

    //override the methods below
    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_plates, parent, false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        PlateModel plateModel = plateModelList.get(position);
        Glide.with(context).load(plateModel.getPlate_img()).into(holder.plateimg);
    }

    @Override
    public int getItemCount() {
        return plateModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {

        private ImageView plateimg;

        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);

            plateimg = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
