package com.example.recyclerview_listview.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerview_listview.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private static final String TAG = GridAdapter.class.getSimpleName();

    private Context context;

    private List<String> mList = new ArrayList<>();
    private ChangeListener listener;

    public GridAdapter(Context context) {
        this.context = context;
    }

    public void setVerticalDataList(List<String> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void addItem(List<String> beanList) {
        mList.addAll(beanList);
        notifyDataSetChanged();
    }



    public interface ChangeListener{
        void onItemClick(View view, int position);
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.btn2_grid_img.setImageResource(R.mipmap.a);
        holder.btn2_grid_title.setText(position+"私教深度体验课程3节 (含营养餐)，节假日…");
        holder.btn2_grid_time.setText("2019-10-25 09:50");
        holder.btn2_grid_name.setText("长春市众恒健身管理有限公司");

        if (listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //返回对应view的信息
                    int pos = holder.getLayoutPosition();
                    listener.onItemClick(holder.itemView,pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView btn2_grid_img;
        TextView btn2_grid_title,btn2_grid_time,btn2_grid_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn2_grid_img = itemView.findViewById(R.id.xinimage);
            btn2_grid_title = itemView.findViewById(R.id.xint);
            btn2_grid_time = itemView.findViewById(R.id.xint1);
            btn2_grid_name = itemView.findViewById(R.id.xint2);
        }
    }
}
