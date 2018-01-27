package com.edge.weather.unithon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Replacetodo extends Activity {
    EditText addtodotext;
    Button addtodobutton;
    DatePicker addtododate;
    String todo;
    int year,month,day;
    int cyear,cmonth,cday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this.getIntent());
        String title = intent.getStringExtra("title");
        int  position = intent.getIntExtra("position",1);


        Calendar cal = Calendar.getInstance();
        cyear = cal.get ( cal.YEAR );
        cmonth = cal.get ( cal.MONTH )+1;
        cday = cal.get ( cal.DATE );
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags  = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_replacetodo);
        addtodotext = (EditText)findViewById(R.id.addtodotext);
        addtodotext.setHint(title);
        addtodobutton = (Button)findViewById(R.id.addtodobutton);
        addtododate = (DatePicker)findViewById(R.id.addtododate);

        addtodobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                todo= addtodotext.getText().toString();
                year = addtododate.getYear();
                month =addtododate.getMonth()+1;
                day = addtododate.getDayOfMonth();
                if(year>=cyear&&month>=cmonth) {
                    returnIntent.putExtra("Todo", todo + "");
                    returnIntent.putExtra("Date", year + "/" + month + "/" + day);
                   toDOViewAdapter toDOViewAdapter = new toDOViewAdapter();
                 //  toDOViewAdapter.replaceItem(position,title);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "현재날짜 이후의 날짜를 입력해야합니다.", Toast.LENGTH_SHORT).show();
                }







            }
        });
    }

}
