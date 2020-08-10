package com.example.recyclerview_listview.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_listview.MainActivity;
import com.example.recyclerview_listview.R;


import java.util.ArrayList;
import java.util.List;

public class ListActivity  extends AppCompatActivity implements View.OnClickListener {
    private ImageView fanhui;//返回
    private List<ListModel> datas;
    private RecyclerView myRecyclerView;
    private ListAdapter myRecycleViewAdapter;

    private RecyclerView ryid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);

        initData();
        ivtview();
    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add(new ListModel("AAAAA","2019-10-24 20:46",R.mipmap.a));
        datas.add(new ListModel("BBBBB","2019-10-24 20:47",R.mipmap.b));
        datas.add(new ListModel("CCCCC","2019-10-24 20:48",R.mipmap.c));
        datas.add(new ListModel("AAAAA","2019-10-24 20:46",R.mipmap.a));
        datas.add(new ListModel("BBBBB","2019-10-24 20:47",R.mipmap.b));
        datas.add(new ListModel("CCCCC","2019-10-24 20:48",R.mipmap.c));
        datas.add(new ListModel("AAAAA","2019-10-24 20:46",R.mipmap.a));
        datas.add(new ListModel("BBBBB","2019-10-24 20:47",R.mipmap.b));
        datas.add(new ListModel("CCCCC","2019-10-24 20:48",R.mipmap.c));

    }

    private void ivtview() {
        fanhui = (ImageView) findViewById(R.id.fanhui);
        fanhui.setOnClickListener(this);

        ryid  = (RecyclerView) findViewById(R.id.ryid);
        ryid.setOnClickListener(this);

        myRecyclerView = (RecyclerView)findViewById(R.id.ryid);
        myRecycleViewAdapter = new ListAdapter(datas,ListActivity.this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        myRecyclerView.setAdapter(myRecycleViewAdapter);
    }

    public void myItemClick(View view){
        //获取itemview的位置
        int position = myRecyclerView.getChildAdapterPosition(view);
        startActivity(new Intent(ListActivity.this, MainActivity.class));
//        Toast.makeText(HuiYuanActivity.this,"点击了"+position,
//                Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fanhui:
                finish();
                break;

            case R.id.ryid:
                startActivity(new Intent(ListActivity.this,MainActivity.class));
                break;
        }
    }
}