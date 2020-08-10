package com.example.recyclerview_listview.listgrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.recyclerview_listview.R;


import java.util.List;

public class MyGridAdapter extends BaseAdapter {

    private List<ListGridModel> datas;
    private Context context;

    public MyGridAdapter(List<ListGridModel> datas, Context context){
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return getItemId(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ListGridModel baseModel = datas.get(i);
        ViewHolder viewHolder;
        if (convertView == null) {

            LayoutInflater inflater= LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.gridview_item_layout,viewGroup,false);

            viewHolder=new ViewHolder();
            viewHolder.itemImage=(ImageView)convertView.findViewById(R.id.gimageviewid);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.itemImage.setImageResource(baseModel.getImg());

        return convertView;
    }

    class ViewHolder {
        ImageView itemImage;

    }
}
