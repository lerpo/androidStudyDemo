package com.example.androiddemo.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androiddemo.R;

public class LabelImageIcon extends LinearLayout {

    private ImageView icon;
    private TextView label;
    public LabelImageIcon(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.ui_label_image, this);
        // 获取控件
        icon = (ImageView) view.findViewById(R.id.icon);
        label = (TextView) view.findViewById(R.id.label);
    }

    public void setIcon(Drawable icon) {
        this.icon.setImageDrawable(icon);
    }

    public void setLabel(String label) {
        this.label.setText(label);
    }
}
