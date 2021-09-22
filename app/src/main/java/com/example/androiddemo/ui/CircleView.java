package com.example.androiddemo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class CircleView extends View {
    private int mMeasureHeigth;// 控件高度
    private int mMeasureWidth;// 控件宽度
    // 圆形
    private Paint mCirclePaint;
    private float mCircleXY;//圆心坐标
    private float mRadius;//圆形半径

    // 文字
    private Paint mTextPaint;
    private String mShowText;//文本内容
    private float mShowTextSize;//文本大小

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    // 如果不用后面的参数，就不需要重构后面的，直接将其内容写在第一个构造方法就可以，父类会自动执行后面的构造方法
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        // 初始化操作
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);//获取控件宽度
        mMeasureHeigth = MeasureSpec.getSize(heightMeasureSpec);//获取控件高度
        setMeasuredDimension(mMeasureWidth, mMeasureHeigth);
        initPaint();  // 画笔中用到了宽高所以在此初始化画笔
    }

    /**
     * 准备画笔，
     */
    private void initPaint() {
        float length = Math.min(mMeasureWidth,mMeasureHeigth);
        // 圆的代码
        mCircleXY = length / 2;// 确定圆心坐标
        mRadius = (float) (length * 0.5 / 2);// 确定半径
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);// 去锯齿
        mCirclePaint.setColor(getResources().getColor(android.R.color.background_dark));

        // 文字，只需要设置好文字的起始绘制位置即可
        mShowText = "EZR";
        mShowTextSize = 50;
        mTextPaint = new Paint();
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setColor(getResources().getColor(android.R.color.white));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        // 绘制文字
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, mCircleXY + mShowTextSize / 4, mTextPaint);
    }
}
