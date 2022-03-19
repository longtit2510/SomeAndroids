package com.example.chuanbi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuanbi.R;
import com.example.chuanbi.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{
    private List<Cat> slst;

    public SearchAdapter() {
        slst = new ArrayList<>();
    }

    public void setSlst(List<Cat> slst) {
        this.slst = slst;
        notifyDataSetChanged();
    }
    private List<Cat> getList(){
        return slst;
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);

        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Cat cat = slst.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice() + "");
        holder.desc.setText(cat.getInfor());
    }

    @Override
    public int getItemCount() {
        return slst.size();
    }

    public  class SearchViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,price,desc;
        public SearchViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            price = view.findViewById(R.id.item_price);
            desc = view.findViewById(R.id.item_desc);
        }
    }
}
