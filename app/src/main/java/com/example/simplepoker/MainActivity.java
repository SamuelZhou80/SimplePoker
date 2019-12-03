package com.example.simplepoker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<Modules> mToolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_list);

        initTitle();
        initList();
        ToolListAdapter adapter = new ToolListAdapter();
        ListView listView = (ListView) findViewById(R.id.listview_tools);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mToolList != null && mToolList.size() > position) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, mToolList.get(position).moduleClass);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getApp().exitApp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initTitle() {
        TextView textViewTitle = (TextView) findViewById(R.id.commontitle_textview);
        textViewTitle.setText("小工具");

        Button btnReturn = (Button) findViewById(R.id.common_btn_left);
        btnReturn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        Button btnRight = (Button) findViewById(R.id.common_btn_right);
        // btnRight.setVisibility(View.GONE);
        btnRight.setText("拷贝数据库");
        btnRight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                copyDbFile();
                // MakeRegisterKey.outputKey();
            }
        });
    }

    private void initList() {
        mToolList = new ArrayList<Modules>();
//        mToolList.add(new Modules("贷款计算器", CalcLoanActivity.class));
//        mToolList.add(new Modules("投资收益计算", CalcInvestActivity.class)); // 投资计算器
        mToolList.add(new Modules("24点游戏", PlayPoker24.class));
//        mToolList.add(new Modules("汉字编码工具", GBKToUTFActivity.class));
//        mToolList.add(new Modules("图像识别", PhotoDetectActivity.class));
//        mToolList.add(new Modules("姓名统计", SearchNameActivity.class));
//        mToolList.add(new Modules("配速计算器", PacerCalculate.class));
//        mToolList.add(new Modules("Eco数据分析", EcoDataTest.class));
//        mToolList.add(new Modules("正则表达式", PatternMatchTest.class));
    }

    private void copyDbFile() {

    }

    private class ToolListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mToolList != null) {
                return mToolList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return mToolList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                convertView = inflater.inflate(R.layout.common_listview_item, parent, false);
                holder = new ViewHolder();
                holder.txtView = (TextView) convertView.findViewById(R.id.text);
                holder.txtView.setText(mToolList.get(position).name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            return convertView;
        }

        class ViewHolder {
            TextView txtView;
            // ImageView image;
        }
    }

    private class Modules {
        String name;
        Class<?> moduleClass;

        Modules(String name, Class<?> className) {
            this.name = name;
            this.moduleClass = className;
        }
    }

}
