package com.edge.weather.unithon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;
import java.util.Random;

public class ReservationActivity extends Activity {
ImageView reservation;
ImageView reservation_cancle;

String todo;

String date;
String email;
String token;
String year;
String month;
String day;

String end_day;
JsonObject jsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson=new Gson();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Intent intent=getIntent();
        todo=(String)intent.getExtras().get("Todo");
        year=(String)intent.getExtras().get("year");
        month=(String)intent.getExtras().get("month");
        day=(String)intent.getExtras().get("day");
        email=(String)intent.getExtras().get("email");
        date=year+"-"+month+"-"+day;
        token=(String) intent.getExtras().get("token");
        end_day=year+month+day;
        final Random random=new Random();
        final String rn=((random.nextInt()*1500)+1)+"";
        Log.d("끝",end_day);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags  = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 15f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_reservation);
        reservation=(ImageView)findViewById(R.id.reservation);
        reservation_cancle=(ImageView)findViewById(R.id.reservation_cancle);
        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*new CreateTodo().execute();*/
                JsonObject jsonObject=new JsonObject();
                jsonObject.addProperty("title",todo);
                jsonObject.addProperty("done",false);
                jsonObject.addProperty("date",date);
                MainActivity.toDOViewAdapter.addItem(jsonObject);
                CalendarCall calendarCall=new CalendarCall();
                calendarCall.setAccess_token(token);
                calendarCall.setStart_day("20180128");
                calendarCall.setEnd_day(end_day);
                calendarCall.setTitle(todo);
                calendarCall.setEmail(email);
                calendarCall.setCal_id(rn);
                calendarCall.execute();
                calendarCall=new CalendarCall();
                calendarCall.setAccess_token(token);
                calendarCall.setStart_day("20180128");
                calendarCall.setEnd_day(end_day);
                calendarCall.setTitle(todo);
                calendarCall.setEmail(email);
                calendarCall.setCal_id(rn);
                calendarCall.execute();
                finish();
            }
        });
        reservation_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
