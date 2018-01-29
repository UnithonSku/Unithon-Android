package com.edge.weather.unithon;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
=======
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
<<<<<<< HEAD
import android.widget.ImageView;
=======
import android.widget.Toast;

import java.util.Calendar;
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01

public class WritetodoList extends Activity {
EditText addtodotext;
ImageView addtodobutton;
DatePicker addtododate;
String todo;
int year,month,day;
<<<<<<< HEAD
ImageView Write_finish;
String token;
String email;

=======
int cyear,cmonth,cday;
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       Calendar cal = Calendar.getInstance();
       cyear = cal.get ( cal.YEAR );
       cmonth = cal.get ( cal.MONTH )+1;
       cday = cal.get ( cal.DATE );

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags  = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_writetodo_list);
        addtodotext = (EditText)findViewById(R.id.addtodotext);
        addtodobutton = (ImageView)findViewById(R.id.addtodobutton);
        addtododate = (DatePicker)findViewById(R.id.addtododate);
        Write_finish=(ImageView)findViewById(R.id.Write_finish);

        Intent intent=getIntent();
        token=(String)intent.getExtras().get("token");
        email=(String)intent.getExtras().get("email");

        Write_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addtodobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WritetodoList.this, ReservationActivity.class);
                   todo= addtodotext.getText().toString();
                   year = addtododate.getYear();
                   month =addtododate.getMonth()+1;
                   day = addtododate.getDayOfMonth();
<<<<<<< HEAD
                intent.putExtra("Todo",todo+"");
                intent.putExtra("year",year+"");
                if(month>10){
                    intent.putExtra("month",month+"");
                }else{
                    intent.putExtra("month","0"+month+"");
                }
                if(day>10){
                    intent.putExtra("day",day+"");
                }else{
                    intent.putExtra("day","0"+day+"");
                }


                intent.putExtra("token",token+"");
                intent.putExtra("email",email+"");
                startActivity(intent);
                finish();
=======
                  if(year>=cyear&&month>=cmonth) {
                      returnIntent.putExtra("Todo", todo + "");
                      returnIntent.putExtra("Date", year + "/" + month + "/" + day);
                      setResult(Activity.RESULT_OK, returnIntent);
                      finish();
                  }
                  else
                  {
                      Toast.makeText(getApplicationContext(), "현재날짜 이후의 날짜를 입력해야합니다.", Toast.LENGTH_SHORT).show();
                  }



              //데이터 다시 전달 하면 된다.
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01



            }
        });
    }

}
