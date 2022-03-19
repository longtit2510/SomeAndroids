package com.example.chuanbi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuanbi.MainActivity;
import com.example.chuanbi.R;
import com.example.chuanbi.adapter.CatAdapter;
import com.example.chuanbi.adapter.SpinnerAdapter;
import com.example.chuanbi.model.Cat;

public class FragmentAdd extends Fragment implements CatAdapter.CatItemListener{
    private CatAdapter adapter;
    private Spinner spinner;
    private EditText editName,editPrice,editDesc;
    private Button btnadd, btnupdate;
    private RecyclerView recyclerView;

    private int CurrentPos;

    private int[] imgs = {R.drawable.cat1,R.drawable.cat2,
            R.drawable.cat3,R.drawable.cat4};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        adapter = new CatAdapter((MainActivity) getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = spinner.getSelectedItem().toString();
                int img;
                try{
                    img = imgs[Integer.parseInt(i)];
                    double price = Double.parseDouble(editPrice.getText().toString());
                    Cat cat = new Cat(img,editName.getText().toString(),price,editDesc.getText().toString());
                    adapter.add(cat);
                }catch(Exception e){

                }
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = spinner.getSelectedItem().toString();
                int img;
                try{
                    img = imgs[Integer.parseInt(i)];
                    double price = Double.parseDouble(editPrice.getText().toString());
                    Cat cat = new Cat(img,editName.getText().toString(),price,editDesc.getText().toString());
                    adapter.update(CurrentPos,cat);
                    btnupdate.setVisibility(View.INVISIBLE);
                    btnadd.setVisibility(View.VISIBLE);
                }catch(Exception e){

                }
            }
        });
    }

    private void init(View view){
        spinner = view.findViewById(R.id.spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(),imgs);
        spinner.setAdapter(adapter);
        editName = view.findViewById(R.id.editName);
        editPrice = view.findViewById(R.id.editPrice);
        editDesc = view.findViewById(R.id.editDesc);
        btnadd = view.findViewById(R.id.btnAdd);
        btnupdate = view.findViewById(R.id.btnUpdate);
        recyclerView = view.findViewById(R.id.reView);
        btnupdate.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onItemClick(View view, int pos) {
        btnadd.setVisibility(View.INVISIBLE);
        btnupdate.setVisibility(View.VISIBLE);
        CurrentPos = pos;
        Cat cat = adapter.getItem(pos);
        int img = cat.getImg();
        int p = 0;
        for(int i =0; i<imgs.length;i++){
            if(img == imgs[i]){
                p = i;
                break;
            }
        }
        spinner.setSelection(p);
        editName.setText(cat.getName());
        editPrice.setText(cat.getPrice() + "");
        editDesc.setText(cat.getInfor());
    }
}
