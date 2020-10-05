package com.example.mywork_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ViewHolder>{

    private List<Clothes> mClothesList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView clothesImage;
        TextView clothesName;

        public ViewHolder(View view){
            super(view);
            clothesImage = (ImageView) view.findViewById(R.id.clothes_image);
            clothesName = (TextView) view.findViewById(R.id.clothes_name);
        }
    }

    public ClothesAdapter(List<Clothes> clothesList){
        mClothesList = clothesList;
    }

    @Override
    public ClothesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clothes_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClothesAdapter.ViewHolder holder, int position) {
        Clothes clothes = mClothesList.get(position);
        holder.clothesImage.setImageResource(clothes.getImageId());
        holder.clothesName.setText(clothes.getName());
    }

    @Override
    public int getItemCount() {
        return mClothesList.size();
    }
}
