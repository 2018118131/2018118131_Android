package com.example.mywork_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Clothes> clothesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initClothes(){
        for(int i = 0;i<2;i++){
            Clothes t_shirt = new Clothes("T恤衫",R.drawable.t_shirt);
            clothesList.add(t_shirt);
            Clothes beach = new Clothes("沙滩裤",R.drawable.beach);
            clothesList.add(beach);
            Clothes blouse = new Clothes("长衬衫",R.drawable.blouse);
            clothesList.add(blouse);
            Clothes fleece = new Clothes("卫衣",R.drawable.fleece);
            clothesList.add(fleece);
            Clothes pants = new Clothes("长裤",R.drawable.pants);
            clothesList.add(pants);
            Clothes short_sleeve = new Clothes("短衬衫",R.drawable.short_sleeve);
            clothesList.add(short_sleeve);
            Clothes shorts = new Clothes("短裤",R.drawable.shorts);
            clothesList.add(shorts);
            Clothes suit_pant = new Clothes("西装",R.drawable.suit_pant);
            clothesList.add(suit_pant);
            Clothes sweater = new Clothes("毛衣",R.drawable.sweater);
            clothesList.add(sweater);
            Clothes swimwear = new Clothes("泳衣",R.drawable.swimwear);
            clothesList.add(swimwear);
        }
    }
}