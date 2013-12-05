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
		// //注意这里的代码， 它找的是边长最小的那个
		// int size = width > height ? height : width;
		// setMeasuredDimension(size, size);
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);

	}
}
