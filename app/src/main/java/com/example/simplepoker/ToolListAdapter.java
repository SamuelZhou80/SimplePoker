package com.example.simplepoker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ToolListAdapter extends BaseAdapter {
    private ArrayList<Modules> mToolList;
    private Context mContext;

    public ToolListAdapter(ArrayList<Modules> list, Context context) {
        mToolList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        if (mToolList != null) {
            return mToolList.size();
        }
        return 0;
    }

    @Override
    public Modules getItem(int position) {
        return mToolList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.common_listview_item, parent, false);
            holder = new ViewHolder();
            holder.txtView = (TextView) convertView.findViewById(R.id.text);
            holder.txtView.setText(mToolList.get(position).name);
            convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        TextView txtView;
        // ImageView image;
    }
}
