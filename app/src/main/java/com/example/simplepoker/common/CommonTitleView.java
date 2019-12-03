package com.example.simplepoker.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.simplepoker.R;

/**
 * 公共标题栏组件
 */
public class CommonTitleView extends LinearLayout {
    public CommonTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonTitleView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        String infServiString = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater lInflater;
        lInflater = (LayoutInflater) getContext().getSystemService(infServiString);
        lInflater.inflate(R.layout.common_title, this, true);
    }
}
