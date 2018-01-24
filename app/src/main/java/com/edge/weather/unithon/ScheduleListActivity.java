package com.edge.weather.unithon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ScheduleListActivity extends AppCompatActivity {
    /*private Map<String,List<ScheduleVO>> schedule_list_completed;
    private List<ScheduleVO> applicable_period_schedule_list;*/
    private Map<String,List<String>> schedule_list_completed;
    private List<String> applicable_period_schedule_list;
    ListView period_lv;
    ListView schedule_lv;
    CustomAdapter schedule_adapter;

    List<String> period_list;
    List<String> schedule_list=new ArrayList<String>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);

        Gson gson=new Gson();

        JsonObject data1=new JsonObject();
        data1.addProperty("deadline","2017/05/11");
        data1.addProperty("title","줄넘기 50개");
        data1.addProperty("content","매일 아침 9시에 줄넘기 50개하기");

        Log.d("데이터 포맷팅",data1.toString());





        schedule_list_completed=new HashMap<String,List<String>>();
        applicable_period_schedule_list= new ArrayList<String>();

        applicable_period_schedule_list.add("줄넘기 50개");
        applicable_period_schedule_list.add("아침먹고 출근하기");
        schedule_list_completed.put("2017/10/10~2017/12/15",applicable_period_schedule_list);

        applicable_period_schedule_list=new ArrayList<String>();
        applicable_period_schedule_list.add("영단어 50개 외우기");
        applicable_period_schedule_list.add("백준 1개 풀기");
        applicable_period_schedule_list.add("자격증 공부하기");
        schedule_list_completed.put("2017/02/15~2017/02/25",applicable_period_schedule_list);

        period_list=new ArrayList<String>(schedule_list_completed.keySet());
        Collections.sort(period_list);
        period_lv=findViewById(R.id.period_list);
        schedule_lv=findViewById(R.id.schedule_list);

        CustomAdapter period_adapter=new CustomAdapter(period_list,1);
        period_lv.setAdapter(period_adapter);

        schedule_adapter=new CustomAdapter(schedule_list,2);
        schedule_lv.setAdapter(schedule_adapter);

    }

    class CustomAdapter extends BaseAdapter {
        List list;
        int division;
        public CustomAdapter(List list,int division){
            this.division=division;
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            if(division==1){
                view=getLayoutInflater().inflate(R.layout.row_period,null);
                ((Button)view.findViewById(R.id.row_period)).setText(list.get(i).toString());
                ((Button)view.findViewById(R.id.row_period)).setTag("true");
                view.findViewById(R.id.row_period).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if("true".equals(view.findViewById(R.id.row_period).getTag().toString())){
                            for(int j=0;j<schedule_list_completed.get(list.get(i)).size();j++){
                                schedule_list.add(schedule_list_completed.get(list.get(i)).get(j).toString());

                            }
                            view.findViewById(R.id.row_period).setTag("false");
                        }else{
                            for(int j=0;j<schedule_list_completed.get(list.get(i)).size();j++){
                                schedule_list.remove(schedule_list_completed.get(list.get(i)).get(j).toString());

                            }
                            view.findViewById(R.id.row_period).setTag("true");
                        }
                        schedule_adapter.notifyDataSetChanged();
                    }
                });
            }else{
                view=getLayoutInflater().inflate(R.layout.row_schedule,null);
                ((TextView)view.findViewById(R.id.row_schedule)).setText(list.get(i).toString());
            }
            return view;
        }
    }
}
