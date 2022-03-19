package com.example.firstandroidpj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.firstandroidpj.model.NhanVien;
import com.example.firstandroidpj.model.NhanVienAdapter;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText edit1,edit2;
    private RadioButton r1,r2;
    private TextView rs;
    private RecyclerView recyclerView;
    private int imgView;

    private NhanVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        adapter = new NhanVienAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien();
                String ma = edit1.getText().toString();
                String name = edit2.getText().toString();
                try{
                    if(r1.isChecked()){
                        imgView = 0;
                    }
                    if(r2.isChecked()){
                       imgView = 1;
                    }
                } catch(Exception e) {

                }
                nv.setImg(imgView);
                nv.setMa(ma);
                nv.setName(name);
                adapter.add(nv);
            }
        });

    }
    private void Init(){
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        btn = findViewById(R.id.btn);
        r1 = findViewById(R.id.radio1);
        r2 = findViewById(R.id.radio2);
        recyclerView = findViewById(R.id.recyclerview);
    }

}