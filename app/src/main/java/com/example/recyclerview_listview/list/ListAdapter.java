package com.example.recyclerview_listview.list;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_listview.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {

    private List<ListModel> datas;
    private Context context;
    private LayoutInflater inflater;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_IMAGE = 2;


    public ListAdapter(List<ListModel> datas, Context context) {
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
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ThreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ThreeViewHolder) {
            ListModel model = (ListModel) datas.get(position);
            ThreeViewHolder threeViewHolder = (ThreeViewHolder) holder;

            threeViewHolder.textView2.setText(model.getNametype());
            threeViewHolder.textView3.setText(model.getTime());


        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
//
//    public int getItemViewType(int position) {
//
//        return datas.get(position).getType();
//    }

    public class ThreeViewHolder extends RecyclerView.ViewHolder {
        private TextView textView2;
        private TextView textView3;
        private Image image;

        public ThreeViewHolder(@NonNull View itemView ) {
            super(itemView);
            textView2 = (TextView) itemView.findViewById(R.id.titletextid);
            textView3 = (TextView) itemView.findViewById(R.id.timetextid);
            // image = (Image) itemView.findViewById(R.id.iconimgid);

        }
    }
}
