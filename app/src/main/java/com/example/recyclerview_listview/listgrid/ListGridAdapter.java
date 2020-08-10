package com.example.recyclerview_listview.listgrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_listview.R;


import java.util.List;

public class ListGridAdapter extends RecyclerView.Adapter {

    private List<ListGridModel> datas;
    private Context context;
    private LayoutInflater inflater;
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_AD = 1;
    public static final int TYPE_TEXT = 2;
    public static final int TYPE_IMAGE = 3;

    public ListGridAdapter(List<ListGridModel> datas, Context context){

        this.datas = datas;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (context == null)
            context = parent.getContext();
        if (inflater == null)
            inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listgrid_item,parent,false);
        return new ThreeViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



        if (holder instanceof ThreeViewHolder) {
            ListGridModel model = (ListGridModel) datas.get(position);
            ThreeViewHolder threeViewHolder = (ThreeViewHolder)holder;
            threeViewHolder.img3.setImageResource(model.getImg());
            threeViewHolder.textView3.setText(model.getNametype());
            MyGridAdapter myGridAdapter = new MyGridAdapter(datas,context);
            threeViewHolder.myGridView.setAdapter(myGridAdapter);

        }



    }

    @Override
    public int getItemCount() {

        return datas.size();
    }
    public int getItemViewType(int position) {

        return datas.get(position).getType();


    }



    public class ThreeViewHolder extends RecyclerView.ViewHolder{
        private ImageView img3;
        private TextView textView3;
        private MyGridView myGridView;
        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            img3= (ImageView)itemView.findViewById(R.id.xtou);
            textView3 = (TextView)itemView.findViewById(R.id.xtexttou);
            myGridView = (MyGridView)itemView.findViewById(R.id.mygvid);


            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //此处回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v, datas.get(getLayoutPosition()));
                    }
                }
            });

        }
    }


    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, ListGridModel data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



}
