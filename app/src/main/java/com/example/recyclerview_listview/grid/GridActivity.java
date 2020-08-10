package com.example.recyclerview_listview.grid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_listview.MainActivity;
import com.example.recyclerview_listview.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity  extends AppCompatActivity {
    private View view;

    private GridAdapter adapter;
    //recyclerview
    private static final String TAG = GridActivity.class.getSimpleName();

    private List<String> mList = new ArrayList<>();

    private int lastVisibleItem;

    private int total = 0;
    private int start = 0;
    private int count = 10;
    private int count1 = 0;
    private GridLayoutManager manager;
    private TextView bottom_text;


    @Nullable

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gird_main);
        initData(10);
        initBtn2GridView();

    }

    @SuppressLint("WrongConstant")
    private void initBtn2GridView() {
        bottom_text = (TextView) findViewById(R.id.bottom_text);
        adapter = new GridAdapter(GridActivity.this);
        RecyclerView recyclerView =  findViewById(R.id.rcv_vertical);

        manager = new GridLayoutManager(GridActivity.this,2);

        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter.setVerticalDataList(mList);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new GridAdapter.ChangeListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(GridActivity.this, MainActivity.class));
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                // 判断 RecyclerView 的状态是空闲时，同时是最后一个可见的 item 时才加载
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                        lastVisibleItem + 1 == adapter.getItemCount()){
                    Log.d(TAG, "onScrollStateChanged: 上拉加载");

           /*         total = total - count1;

                    Log.d(TAG, "onScrollStateChanged: " + total);

                    if (total > count){
                        Log.d(TAG, "onScrollStateChanged: >");
                        count = 10;
                        start = 10;

                        initData(mList.size());
                    }else if (total < count && total > 0){
                        Log.d(TAG, "onScrollStateChanged: <");
                        count = total;
                        start = 20;

                        initData(mList.size());
                    }else if (total == 0){
                        Log.d(TAG, "onScrollStateChanged: =");

                        count = total;

                        bottom_text.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(), "已经没有数据了", Toast.LENGTH_SHORT).show();
                    }*/

                    if (total == count1){
                        bottom_text.setVisibility(View.VISIBLE);
                        Toast.makeText(GridActivity.this, "已经没有数据了", Toast.LENGTH_SHORT).show();
                    }else {
                        count1 = total;
                        initData(mList.size());
                        adapter.notifyDataSetChanged();
                    }


                }


            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 最后一个可见的 item
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }
        });


    }

    private void initData(int count) {

        if (count<30){
            List<String> lm = new ArrayList<>();
            for (int i=0;i<count;i++){
                lm.add("count"+i);
            }
            mList.addAll(lm);
            total = mList.size();
        }

    }


}
