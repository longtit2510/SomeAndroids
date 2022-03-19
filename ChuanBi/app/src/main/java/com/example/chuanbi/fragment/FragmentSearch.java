package com.example.chuanbi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuanbi.MainActivity;
import com.example.chuanbi.R;
import com.example.chuanbi.adapter.SearchAdapter;
import com.example.chuanbi.model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FragmentSearch extends Fragment {
    private SearchAdapter adapter;
    private SearchView sview;
    private RecyclerView recyclerView;
    private List<Cat> clst;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sview = view.findViewById(R.id.search);
        recyclerView = view.findViewById(R.id.reViewSearch);
        adapter= new SearchAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        sview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
            private void filter(String s){
                List<Cat> filterlst = new ArrayList<>();
                for(Cat i:clst){
                    if(i.getName().toLowerCase().contains(s.toLowerCase())){
                        filterlst.add(i);
                    }
                }
                if(filterlst.isEmpty()){
                    Toast.makeText(getContext(),"Khong co du lieu",Toast.LENGTH_SHORT).show();

                } else {
                    adapter.setSlst(filterlst);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        clst = ((MainActivity) getActivity()).lst;
    }
}
