package com.example.chuanbi.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuanbi.MainActivity;
import com.example.chuanbi.R;
import com.example.chuanbi.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<Cat> lst;
    private MainActivity mainActivity;
    private CatItemListener itemListener;

    public CatAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        lst = new ArrayList<>();
    }


    public Cat getItem(int pos){
        return lst.get(pos);
    }

    public List<Cat> getList(){
        return lst;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = lst.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice() + "");
        holder.desc.setText(cat.getInfor());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Ban co chac chan muon xoa khong?");
                builder.setTitle("Thong bao xoa");
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lst.remove(position);
                        notifyDataSetChanged();
                        mainActivity.lst = lst;
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public void setItemListener(CatItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView img;
        TextView name,price,desc;
        Button btnRemove;
        public CatViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            price = view.findViewById(R.id.item_price);
            desc = view.findViewById(R.id.item_desc);
            btnRemove = view.findViewById(R.id.item_btnRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener != null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface CatItemListener{
        void onItemClick(View view,int pos);
    }
    public void add(Cat cat){
        lst.add(cat);
        notifyDataSetChanged();
        mainActivity.lst = lst;
    }
    public void update(int pos,Cat cat){
        lst.set(pos,cat);
        notifyDataSetChanged();
        mainActivity.lst = lst;
    }
}
