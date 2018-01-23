package com.edge.weather.unithon;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    toDOViewAdapter toDOViewAdapter;
    ImageView userimage,userimagethink;
    Button newtodo;
    ListView listView;
    FloatingActionButton floatingActionButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userimage = (ImageView)findViewById(R.id.userimage);

        //캐릭터 말풍선 이미지뷰
        userimagethink = (ImageView)findViewById(R.id.userimagethink);
        newtodo = (Button)findViewById(R.id.Newtodo) ;
        listView = (ListView)findViewById(R.id.list_view);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
<<<<<<< HEAD
        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
=======
>>>>>>> 4acf241cfa60fde4a1e30ac288a5c35938728361
        //말풍선 쓰레드 시작
        UserThinking userThinking = new UserThinking();
        userThinking.start();


        //GIF 파일 넣는 코드
        GlideDrawableImageViewTarget Userimage = new GlideDrawableImageViewTarget(userimage);
        Glide.with(this).load(R.drawable.yawoori).into(Userimage);

        userimagethink.setImageResource(R.drawable.thinking);


        progressBar.setProgress(50);
        toDOViewAdapter = new toDOViewAdapter();
        listView.setAdapter(toDOViewAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ScheduleListActivity.class);
                startActivity(intent);
            }
        });


        //할일 추가하기 버튼 클릭시 발생 이벤트 커스텀 리스트 뷰 한 아이템 추가!
        newtodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WriteActivity.class);
                startActivityForResult(intent,1);
            }
<<<<<<< HEAD
=======

>>>>>>> 4acf241cfa60fde4a1e30ac288a5c35938728361
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

<<<<<<< HEAD
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                ScheduleVO scheduleVO=(ScheduleVO) data.getParcelableExtra("schedule");
                toDOViewAdapter.addItem(scheduleVO.getTitle());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //만약 반환값이 없을 경우의 코드를 여기에 작성하세요.
            }
        }
    }//onActivityResult
    //말풍선을 랜덤으로 보여주고 사라지게 하는 클래스스
    class UserThinking extends Thread {
=======

    //말풍선을 랜덤으로 보여주고 사라지게 하는 클래스스
   class UserThinking extends Thread {
>>>>>>> 4acf241cfa60fde4a1e30ac288a5c35938728361
        int num=3;

        @Override
        public void run() {
            super.run();

            for(;;){
                try{
<<<<<<< HEAD
                    Thread.sleep(1000);
                    Random rnd = new Random();
                    num = rnd.nextInt(100);
                    Log.d("숫자는 ",String.valueOf(num));
=======
                Thread.sleep(1000);
                Random rnd = new Random();
                num = rnd.nextInt(100);
                Log.d("숫자는 ",String.valueOf(num));
>>>>>>> 4acf241cfa60fde4a1e30ac288a5c35938728361


                    Thread.sleep(1000);
                }
                catch(Exception e){}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(num%3==0){
                            userimagethink.setVisibility(View.INVISIBLE);
                        }
                        else{
                            userimagethink.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 4acf241cfa60fde4a1e30ac288a5c35938728361
