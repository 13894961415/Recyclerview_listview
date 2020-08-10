package com.example.recyclerview_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.recyclerview_listview.grid.GridActivity;
import com.example.recyclerview_listview.list.ListActivity;
import com.example.recyclerview_listview.listgrid.ListGridActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private TextView list,grid,listgrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list =(TextView) findViewById(R.id.list);
        list.setOnClickListener(this);
        grid =(TextView) findViewById(R.id.grid);
        grid.setOnClickListener(this);
        listgrid=(TextView) findViewById(R.id.listgrid);
        listgrid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.list:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;
            case R.id.grid:
                startActivity(new Intent(MainActivity.this, GridActivity.class));
                break;
            case R.id.listgrid:
                startActivity(new Intent(MainActivity.this, ListGridActivity.class));
                break;

        }
    }
}
