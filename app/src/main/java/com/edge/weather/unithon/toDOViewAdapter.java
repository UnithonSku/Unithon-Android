package com.edge.weather.unithon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by student on 2018-01-23.
 */

public class toDOViewAdapter extends BaseAdapter {
    private ArrayList<String> myitems= new ArrayList<>();

    @Override
    public int getCount() {
        return myitems.size();
    }

    @Override
    public Object getItem(int position) {
        return myitems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.todo_list_item,parent,false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.todo_list_item);
        title.setText(getItem(position).toString());

        return convertView;
    }
    public void addItem(String title){
        if(myitems.size()<5) {
            myitems.add(title);
            this.notifyDataSetChanged();
        }else{
            //5개가 꽉찼는데 더 추가할려고 하는 경우
        }

    }

}
