package com.example.firstandroidpj.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.firstandroidpj.R;

public class StadiumAdapter extends ArrayAdapter<Stadium> {
    private Context context;
    private Stadium[] lst;

    public StadiumAdapter(@NonNull Context context, Stadium[] lst) {
        super(context, R.layout.item_stadium,lst);
        this.context = context;
        this.lst = lst;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_stadium,null,false);
        ImageView imgview = view.findViewById(R.id.imgView);
        TextView txt1 = view.findViewById(R.id.txtname);
        TextView txt2 = view.findViewById(R.id.txtdiachi);

        Stadium s = lst[position];
        imgview.setImageResource(s.getImg());
        txt1.setText(s.getName());
        txt2.setText(s.getDiachi());
        return view;
    }
    public Stadium getItem(int pos){
        return lst[pos];
    }
}
