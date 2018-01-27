package com.edge.weather.unithon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class WritetodoList extends Activity {
EditText addtodotext;
Button addtodobutton;
DatePicker addtododate;
String todo;
int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags  = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_writetodo_list);
        addtodotext = (EditText)findViewById(R.id.addtodotext);
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
                    returnIntent.putExtra("Todo",todo+"");
                    returnIntent.putExtra("Date",year+"/"+month+"/"+day);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
              //데이터 다시 전달 하면 된다.

            }
        });
    }

}
