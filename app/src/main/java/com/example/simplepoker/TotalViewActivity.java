package com.example.simplepoker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 集合各种控件类型的界面
 */
public class TotalViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_view);

        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initUI() {
        TextView textViewTitle = (TextView) findViewById(R.id.commontitle_textview);
        textViewTitle.setText("控件测试");

        Button btnReturn = (Button) findViewById(R.id.common_btn_left);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalViewActivity.this.finish();
            }
        });

        Button btnRight = (Button) findViewById(R.id.common_btn_right);
        btnRight.setVisibility(View.GONE);

        String[] typeArray = new String[]{"item1", "item2", "item3", "item4", "item5"};
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                R.layout.myspinner, typeArray);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.test_spinner);
        spinner.setAdapter(mAdapter);
        spinner.setPrompt("请选择");
    }

}
