package com.edge.weather.unithon;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class WriteActivity extends AppCompatActivity {
    private  EditText schedule_title;
    private  EditText schedule_content;
    private Button schedule_store;
    private ScheduleVO scheduleVO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        scheduleVO=new ScheduleVO();
        schedule_content=findViewById(R.id.schedule_content);
        schedule_store=findViewById(R.id.schedule_store);
        schedule_title=findViewById(R.id.schedule_title);

        schedule_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                scheduleVO.setContent(schedule_content.getText().toString());
                scheduleVO.setTitle(schedule_title.getText().toString());
                returnIntent.putExtra("schedule", (Parcelable) scheduleVO);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });


    }
}
