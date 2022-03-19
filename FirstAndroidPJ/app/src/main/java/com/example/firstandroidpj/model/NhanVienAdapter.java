package com.example.firstandroidpj.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstandroidpj.R;

import java.util.ArrayList;
import java.util.List;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.NhanVienViewHolder> {
    private Context context;
    private List<NhanVien> nvlst;

    public NhanVienAdapter(Context context) {
        this.context = context;
        nvlst = new ArrayList<>();
    }

    public void add(NhanVien nhanVien){
        nvlst.add(nhanVien);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NhanVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new NhanVienViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull NhanVienViewHolder holder, int position) {
        NhanVien nv = nvlst.get(position);
        if(nv == null){
            return;
        }
        if(nv.getImg() == 0){
            holder.img.setImageResource(R.drawable.male_icon);
        } else {
            holder.img.setImageResource(R.drawable.female_icon);
        }
        holder.txt.setText(nv.getName() + "-" + nv.getMa());

    }

    @Override
    public int getItemCount() {
        if(nvlst!=null){
            return nvlst.size();
        }
        return 0;
    }

    public class NhanVienViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txt;
        private CheckBox checkbox;
        public NhanVienViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.imgitem);
            txt = view.findViewById(R.id.txtitem);
            checkbox = view.findViewById(R.id.checkboxitem);
        }
    }
}
