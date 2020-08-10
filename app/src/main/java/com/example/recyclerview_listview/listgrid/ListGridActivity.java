package com.example.recyclerview_listview.listgrid;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_listview.MainActivity;
import com.example.recyclerview_listview.R;

import java.util.ArrayList;
import java.util.List;

public class ListGridActivity extends AppCompatActivity {
    private ScrollViewContainListView scrolllistview;
    private View view;

    private List<ListGridModel> datas;
    private RecyclerView myRecyclerView;
    private ListGridAdapter myRecycleViewAdapter;
//    public ListGridActivity(Context context){
//        this.context = context;
//    }
//    public ZongHeFuFragment(){}

    @Nullable

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listgrid_main);
        initData();
        initView();
    }



    private void initData() {
        datas = new ArrayList<>();
        datas.add(new ListGridModel(3,"张学迎", R.mipmap.a));
        datas.add(new ListGridModel(2,"巴洛克", R.mipmap.b));
        datas.add(new ListGridModel(3,"样式三", R.mipmap.c));
        datas.add(new ListGridModel(3,"样式三", R.mipmap.a));

    }
    private void initView() {
        myRecyclerView = (RecyclerView) findViewById(R.id.ryid);
        myRecycleViewAdapter = new ListGridAdapter(datas,ListGridActivity.this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(ListGridActivity.this));
        myRecyclerView.setAdapter(myRecycleViewAdapter);
        myRecycleViewAdapter.setOnItemClickListener(new ListGridAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, ListGridModel data) {
                //此处进行监听事件的业务处理
                Toast.makeText(ListGridActivity.this,"item被点击",Toast.LENGTH_SHORT).show();

                //获取itemview的位置
                int position = myRecyclerView.getChildAdapterPosition(view);
                startActivity(new Intent(ListGridActivity.this, MainActivity.class));
            }
        });


    }

}
