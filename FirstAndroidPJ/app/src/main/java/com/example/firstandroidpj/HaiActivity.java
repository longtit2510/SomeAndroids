package com.example.firstandroidpj;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstandroidpj.model.Stadium;
import com.example.firstandroidpj.model.StadiumAdapter;

public class HaiActivity extends AppCompatActivity {
    private ListView lstview;
    private StadiumAdapter adapter;
    private Stadium[] lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hai);

        lstview = findViewById(R.id.lstview);
        initData();
        adapter = new StadiumAdapter(this,lst);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                for(int i = 0;i < lstview.getAdapter().getCount();i++){
                    lstview.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                lstview.getChildAt(pos).setBackgroundColor(Color.GREEN);
                Stadium s = adapter.getItem(pos);
                Toast.makeText(getApplicationContext(),s.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        Integer[] imgs = {R.drawable.stamfordbridge,R.drawable.oldtrafford,R.drawable.etihad,R.drawable.anfield};
        String[] names = {"Stamford Bridge","Old Trafford","Etihad","Anfield"};
        String[] diachis = {"Fulham Rd., London SW6 1HS, Vương quốc Anh", "Sir Matt Busby Way, Old Trafford, Stretford, Manchester M16 0RA, Vương quốc Anh", "Ashton New Rd, Manchester M11 3FF, Vương quốc Anh","Anfield Rd, Anfield, Liverpool L4 0TH, Vương quốc Anh" };
        lst = new Stadium[imgs.length];
        for(int i = 0;i<lst.length;i++){
            lst[i] = new Stadium(imgs[i],names[i],diachis[i]);
        }
    }
}