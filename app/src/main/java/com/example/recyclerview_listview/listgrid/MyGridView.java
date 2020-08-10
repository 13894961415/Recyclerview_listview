package com.example.recyclerview_listview.listgrid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridView extends GridView {

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		//makeMeasureSpec根据提供的大小值和模式创建一个测量值(格式)
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

	
}
