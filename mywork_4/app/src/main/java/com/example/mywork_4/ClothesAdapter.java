package com.example.mywork_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ViewHolder>{

    private List<Clothes> mClothesList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView clothesImage;
        TextView clothesName;
        View clothesView;

        public ViewHolder(View view){
            super(view);
            clothesView = view;
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
        final ViewHolder holder = new ViewHolder(view);
        holder.clothesView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Clothes clothes = mClothesList.get(position);
                Toast.makeText(v.getContext(),"你点击了子项" + clothes.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.clothesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Clothes clothes = mClothesList.get(position);
                Toast.makeText(v.getContext(),"你点击了图片" + clothes.getName(),Toast.LENGTH_SHORT ).show();
            }
        });
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
