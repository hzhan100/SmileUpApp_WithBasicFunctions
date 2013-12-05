package com.smileup.app1_1.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class LinearSquareLayout extends LinearLayout {
	public LinearSquareLayout(Context paramContext) {
		super(paramContext);
	}

	public LinearSquareLayout(Context paramContext,
			AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		// int width = MeasureSpec.getSize(widthMeasureSpec);
		// int height = MeasureSpec.getSize(heightMeasureSpec);
		// int size = Math.min(width, height);
		// super.onMeasure(MeasureSpec.makeMeasureSpec(size,
		// MeasureSpec.EXACTLY),
		// MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY));

		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
		// int width = MeasureSpec.getSize(widthMeasureSpec);
		// int height = MeasureSpec.getSize(heightMeasureSpec);
		// // 注意这里的代码， 它找的是边长最小的那个
		// int size = width > height ? height : width;
		// setMeasuredDimension(size, size);

	}
}

/*
 * Location: C:\Users\Hanyu\Desktop\classes_dex2jar.jar Qualified Name:
 * com.smileup.appv1.customviews.LinearSquareLayout JD-Core Version: 0.6.0
 */