package com.example.androiddemo.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyEditView extends EditText {


    public MyEditView(Context context) {
        super(context);
        initEditText();
    }

    public MyEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEditText();
    }

    public MyEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEditText();
    }

    public MyEditView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initEditText();
    }
    // 初始化edittext 控件
    private void initEditText() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String editable = s.toString();
                String regEx = "[^0-9]";  //只能输入数字
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(editable);
                String str = m.replaceAll("").trim();    //删掉不是字母或数字的字符
                if(!editable.equals(str)){
                    MyEditView.this.setText(str);  //设置EditText的字符
                    MyEditView.this.setSelection(str.length()); //因为删除了字符，要重写设置新的光标所在位置
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
