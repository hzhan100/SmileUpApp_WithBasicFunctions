package com.smileup.app1_1.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareLayout extends RelativeLayout {
	public SquareLayout(Context paramContext) {
		super(paramContext);
	}

	public SquareLayout(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		// int width = MeasureSpec.getSize(widthMeasureSpec);
		// int height = MeasureSpec.getSize(heightMeasureSpec);
		//
		// //ע������Ĵ��룬 ���ҵ��Ǳ߳���С���Ǹ�
		// int size = width > height ? height : width;
		// setMeasuredDimension(size, size);
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);

	}
}
