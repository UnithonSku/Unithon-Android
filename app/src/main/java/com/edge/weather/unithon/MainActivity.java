package com.edge.weather.unithon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;
import java.util.Random;

import static com.edge.weather.unithon.R.raw.song_1;

public class MainActivity extends AppCompatActivity {
    toDOViewAdapter toDOViewAdapter;
    ImageView userimage,userimagethink;

    SwipeMenuListView listView;
    FloatingActionButton schedule_list_btn, floatingActionButton2, floatingActionButton3;;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userimage = (ImageView)findViewById(R.id.userimage);
        String idByANDROID_ID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d("고유값",idByANDROID_ID);

        //캐릭터 말풍선 이미지뷰
        userimagethink = (ImageView)findViewById(R.id.userimagethink);

        listView = (SwipeMenuListView) findViewById(R.id.list_view);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        schedule_list_btn=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.fab2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.fab3);
        //말풍선 쓰레드 시작
        UserThinking userThinking = new UserThinking();
        userThinking.start();
        //GIF 파일 넣는 코드
        GlideDrawableImageViewTarget Userimage = new GlideDrawableImageViewTarget(userimage);
        Glide.with(this).load(R.drawable.yawoori).into(Userimage);

        userimagethink.setImageResource(R.drawable.thinking);


        progressBar.setProgress(50);
        toDOViewAdapter = new toDOViewAdapter();
        /*ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);*/
        listView.setAdapter(toDOViewAdapter);

        schedule_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ScheduleListActivity.class);
                startActivity(intent);
            }
        });

        //할일 추가하기 버튼 클릭시 발생 이벤트 커스텀 리스트 뷰 한 아이템 추가!
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WritetodoList.class);
                startActivityForResult(intent, 1);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Collection.class);
                startActivityForResult(intent, 1);

            }
        });

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                        0xff)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(android.R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // 첫번째 버튼 클릭 시
                        break;
                    case 1:
                        // 두번째 버튼 클릭 시
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                ScheduleVO scheduleVO=(ScheduleVO) data.getParcelableExtra("schedule");
                if(scheduleVO.getTitle().equals("")){
                    Toast.makeText(getApplicationContext(),"할 일을 입력해주세요",Toast.LENGTH_SHORT).show();
                }else{
                    toDOViewAdapter.addItem(scheduleVO.getTitle());
                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //만약 반환값이 없을 경우의 코드를 여기에 작성하세요.
            }
        }
    }//onActivityResult
    //말풍선을 랜덤으로 보여주고 사라지게 하는 클래스스
    class UserThinking extends Thread {
        int num=3;

        @Override
        public void run() {
            super.run();

            for(;;){
                try{
                    Thread.sleep(1000);
                    Random rnd = new Random();
                    num = rnd.nextInt(100);
                    Log.d("숫자는 ",String.valueOf(num));
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
                            //말풍선과 함께 음성도 나오도록!!ㅋㅋㅋㅋㅋㅋ
                            MediaPlayer mPlayer2= MediaPlayer.create(getApplicationContext(),R.raw.song_1);
                            mPlayer2.start();
                        }
                    }
                });
            }
        }
    }


}