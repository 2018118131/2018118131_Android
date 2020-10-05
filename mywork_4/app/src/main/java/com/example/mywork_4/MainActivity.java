package com.example.mywork_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Clothes> clothesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClothes();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ClothesAdapter adapter = new ClothesAdapter(clothesList);
        recyclerView.setAdapter(adapter);
    }

    private void initClothes(){
        for(int i = 0;i<2;i++){
            Clothes t_shirt = new Clothes(getRandomLengthName("T恤衫"),R.drawable.t_shirt);
            clothesList.add(t_shirt);
            Clothes beach = new Clothes(getRandomLengthName("沙滩裤"),R.drawable.beach);
            clothesList.add(beach);
            Clothes blouse = new Clothes(getRandomLengthName("长衬衫"),R.drawable.blouse);
            clothesList.add(blouse);
            Clothes fleece = new Clothes(getRandomLengthName("卫衣"),R.drawable.fleece);
            clothesList.add(fleece);
            Clothes pants = new Clothes(getRandomLengthName("长裤"),R.drawable.pants);
            clothesList.add(pants);
            Clothes short_sleeve = new Clothes(getRandomLengthName("短衬衫"),R.drawable.short_sleeve);
            clothesList.add(short_sleeve);
            Clothes shorts = new Clothes(getRandomLengthName("短裤"),R.drawable.shorts);
            clothesList.add(shorts);
            Clothes suit_pant = new Clothes(getRandomLengthName("西装"),R.drawable.suit_pant);
            clothesList.add(suit_pant);
            Clothes sweater = new Clothes(getRandomLengthName("毛衣"),R.drawable.sweater);
            clothesList.add(sweater);
            Clothes swimwear = new Clothes(getRandomLengthName("泳衣"),R.drawable.swimwear);
            clothesList.add(swimwear);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }

    public void alert_edit(final View view){
        final EditText et = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入服装的名称")
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //按下确定键后的事件
                        final ClothesAdapter.ViewHolder holder = new ClothesAdapter.ViewHolder(view);
                        holder.clothesName.setText(et.getText().toString());
                    }
                }).setNegativeButton("取消",null).show();
    }

}